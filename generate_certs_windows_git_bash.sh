#!/bin/bash
# 生成OpenADR专用PKCS12证书脚本 for Windows Git Bash
# 有效期：10年，使用ECDSA算法

set -e

echo "🔐 开始生成OpenADR专用PKCS12证书文件（ECDSA算法，有效期10年）..."

# 创建证书目录
CERT_DIR="certs/test_certs"
mkdir -p "$CERT_DIR"
cd "$CERT_DIR"

# 清理旧文件
rm -f *.key *.crt *.csr *.p12 *.pem *.srl *.ext 2>/dev/null

# 生成根CA私钥和自签名证书（ECDSA）
echo "📝 生成根CA证书（ECDSA）..."
openssl ecparam -genkey -name prime256v1 -out root_ca.key
openssl req -x509 -new -nodes -key root_ca.key -sha256 -days 3650 -out root_ca.crt \
  -subj "//CN=OpenADR Test Root CA"

# 生成中间CA私钥和证书（ECDSA）
echo "📝 生成中间CA证书（ECDSA）..."
openssl ecparam -genkey -name prime256v1 -out intermediate_ca.key
openssl req -new -key intermediate_ca.key -out intermediate_ca.csr \
  -subj "//CN=OpenADR Test Intermediate CA"
openssl x509 -req -in intermediate_ca.csr -CA root_ca.crt -CAkey root_ca.key -CAcreateserial \
  -out intermediate_ca.crt -days 3650 -sha256

# 生成VTN服务器证书（ECDSA）
echo "📝 生成VTN服务器证书（ECDSA）..."
openssl ecparam -genkey -name prime256v1 -out vtn_server.key

# 创建证书请求配置文件
cat > vtn_server.cnf << 'EOF'
[req]
distinguished_name = req_distinguished_name
req_extensions = v3_req

[req_distinguished_name]
CN = vtn.oadr.com

[v3_req]
subjectAltName = @alt_names

[alt_names]
DNS.1 = vtn.oadr.com
DNS.2 = localhost
IP.1 = 127.0.0.1
EOF

# 创建证书扩展配置文件
cat > vtn_server.ext << 'EOF'
subjectAltName = DNS:vtn.oadr.com, DNS:localhost,IP:127.0.0.1
EOF

openssl req -new -key vtn_server.key -out vtn_server.csr -config vtn_server.cnf
openssl x509 -req -in vtn_server.csr -CA intermediate_ca.crt -CAkey intermediate_ca.key -CAcreateserial \
  -out vtn_server.crt -days 3650 -sha256 -extfile vtn_server.ext

# 生成VEN客户端证书（ECDSA）
echo "📝 生成VEN客户端证书（ECDSA）..."
openssl ecparam -genkey -name prime256v1 -out ven_client.key
openssl req -new -key ven_client.key -out ven_client.csr \
  -subj "//CN=ven123456789012"
openssl x509 -req -in ven_client.csr -CA intermediate_ca.crt -CAkey intermediate_ca.key -CAcreateserial \
  -out ven_client.crt -days 3650 -sha256

# 创建证书链文件
echo "📋 创建证书链文件..."
cat vtn_server.crt intermediate_ca.crt root_ca.crt > vtn_chain.pem
cat ven_client.crt intermediate_ca.crt root_ca.crt > ven_chain.pem

# 生成PKCS12密钥库文件
echo "🔧 生成PKCS12密钥库文件..."
# VTN服务器密钥库（包含完整证书链）
openssl pkcs12 -export -out keystore_vtn.p12 \
  -inkey vtn_server.key -in vtn_chain.pem \
  -name "vtn_server" -password pass:password -noiter -nomaciter

# VEN客户端密钥库（包含完整证书链）
openssl pkcs12 -export -out keystore_ven.p12 \
  -inkey ven_client.key -in ven_chain.pem \
  -name "ven_client" -password pass:password -noiter -nomaciter

# 生成信任库（只包含根CA证书）
echo "🔒 生成信任库文件..."
openssl pkcs12 -export -out truststore.p12 \
  -in root_ca.crt -nokeys \
  -name "root_ca" -password pass:password -noiter -nomaciter


keytool -importcert -file vtn_server.crt -keystore truststore.p12 -storetype PKCS12 -alias vtn_server

keytool -importcert -file ven_client.crt -keystore truststore.p12 -storetype PKCS12 -alias ven_client

keytool -importcert -file intermediate_ca.crt -keystore truststore.p12 -storetype PKCS12 -alias intermediate_ca

keytool -importcert -file root_ca.crt -keystore truststore.p12 -storetype PKCS12 -alias root_ca

# 清理临时文件
rm -f *.csr *.cnf *.ext *.srl

# 验证生成的文件
echo "✅ 验证生成的证书文件..."
echo ""

# 检查keytool是否可用
if command -v keytool &> /dev/null; then
    echo "VTN密钥库信息："
    keytool -list -v -keystore keystore_vtn.p12 -storepass password -storetype PKCS12 | grep -E "别名|条目类型|证书链长度" || true

    echo "VEN密钥库信息："
    keytool -list -v -keystore keystore_ven.p12 -storepass password -storetype PKCS12 | grep -E "别名|条目类型|证书链长度" || true

    echo "信任库信息："
    keytool -list -v -keystore truststore.p12 -storepass password -storetype PKCS12 | grep -E "别名|条目类型" || true
else
    echo "⚠️ keytool 未找到，跳过详细验证"
    echo "生成的文件大小："
    ls -la *.p12
fi

# 创建配置文件示例
echo "📄 生成配置文件示例..."
cat > config.properties << EOF
# VTN 服务器配置
VTN_keystorePath=$(pwd -W)/keystore_vtn.p12
VTN_keystorePassword=password
VTN_keystoreType=PKCS12
VTN_trustStorePath=$(pwd -W)/truststore.p12
VTN_truststorePassword=password
VTN_needClientAuth=true

# VEN 客户端配置
VEN_keystorePath=$(pwd -W)/keystore_ven.p12
VEN_keystorePassword=password
VEN_keystoreType=PKCS12
VEN_trustStorePath=$(pwd -W)/truststore.p12
VEN_truststorePassword=password
VEN_needClientAuth=true

# TLS 配置
TLS_Version=TLSv1.2
Client_TLS12_Ciphers=TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256,TLS_RSA_WITH_AES_128_CBC_SHA256
Server_TLS12_Ciphers=TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256,TLS_RSA_WITH_AES_128_CBC_SHA256
EOF

# 创建Windows路径版本的配置
cat > config_windows.properties << EOF
# VTN 服务器配置 (Windows路径)
VTN_keystorePath=$(pwd -W)\\keystore_vtn.p12
VTN_keystorePassword=password
VTN_keystoreType=PKCS12
VTN_trustStorePath=$(pwd -W)\\truststore.p12
VTN_truststorePassword=password
VTN_needClientAuth=true

# VEN 客户端配置 (Windows路径)
VEN_keystorePath=$(pwd -W)\\keystore_ven.p12
VEN_keystorePassword=password
VEN_keystoreType=PKCS12
VEN_trustStorePath=$(pwd -W)\\truststore.p12
VEN_truststorePassword=password
VEN_needClientAuth=true

# TLS 配置
TLS_Version=TLSv1.2
Client_TLS12_Ciphers=TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256,TLS_RSA_WITH_AES_128_CBC_SHA256
Server_TLS12_Ciphers=TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256,TLS_RSA_WITH_AES_128_CBC_SHA256
EOF

echo ""
echo "🎉 OpenADR专用证书生成完成！"
echo "📁 文件生成在: $(pwd)"
echo ""
echo "🔑 密码均为: password"
echo ""
echo "💡 这些证书支持以下配置："
echo "   - TLSv1.2"
echo "   - TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256"
echo "   - TLS_RSA_WITH_AES_128_CBC_SHA256"
echo ""
echo "📝 配置示例已保存到:"
echo "   - config.properties (Unix路径)"
echo "   - config_windows.properties (Windows路径)"
