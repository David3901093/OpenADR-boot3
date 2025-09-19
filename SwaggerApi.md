

# OpenADR Swagger API

## Endpoints

- VTN Control Swagger UI: https://vtn.oadr.com:8181/testvtn/swagger-ui.html

  [ven-controller](https://vtn.oadr.com:8181/testvtn/swagger-ui/index.html#/ven-controller)

  [market-context-controller](https://vtn.oadr.com:8181/testvtn/swagger-ui/index.html#/market-context-controller)

  [group-controller](https://vtn.oadr.com:8181/testvtn/swagger-ui/index.html#/group-controller)
  
  [demand-response-controller](https://vtn.oadr.com:8181/testvtn/swagger-ui/index.html#/demand-response-controller)
  
  [oadr-20b-ven-controller](https://vtn.oadr.com:8181/testvtn/swagger-ui/index.html#/oadr-20b-ven-controller)
  
  [role-controller](https://vtn.oadr.com:8181/testvtn/swagger-ui/index.html#/role-controller)
  
  [account-controller](https://vtn.oadr.com:8181/testvtn/swagger-ui/index.html#/account-controller)
  
  [oadr-20b-vtn-controller](https://vtn.oadr.com:8181/testvtn/swagger-ui/index.html#/oadr-20b-vtn-controller)
  
  [report-controller](https://vtn.oadr.com:8181/testvtn/swagger-ui/index.html#/report-controller)

## API

### market-context-controller

#### GET /MarketContext/

response body(Code 200)

```json
[
  {
    "id": 1,
    "name": "aaa",
    "description": "test market",
    "color": "#FAFAFA"
  }
]
```

#### POST /MarketContext/

##### case1

request body

```json
{
  "id": 1,
  "name": "aaa",
  "description": "test market",
  "color": "#FAFAFA"
}
```

response body(Code 201)

```json
{
  "id": 1,
  "name": "aaa",
  "description": "test market",
  "color": "#FAFAFA"
}
```

##### case 2

request body

```json
{
  "id": 1,
  "name": "bbb",
  "description": "test market",
  "color": "#FAFAFA"
}
```

response body(Code 201)

```json
{
  "id": 2,
  "name": "bbb",
  "description": "test market",
  "color": "#FAFAFA"
}
```

#### PUT /MarketContext/

##### case 1

request body

```json
{
  "id": 1,
  "name": "ccc",
  "description": "test market",
  "color": "#FAFAFA"
}
```

response body(Code 406)

```json
406	
Error: Not Acceptable
```

##### case 2

request body

```json
{
  "id": 1,
  "name": "aaa",
  "description": "test marketA",
  "color": "#CCCCCCC"
}
```

response body(Code 200)

```json
{
  "id": 1,
  "name": "aaa",
  "description": "test market",
  "color": "#CCCCCCC"
}
```

##### case 3

request body

```json
{
  "id": 3,
  "name": "aaa",
  "description": "test marketA",
  "color": "#CCCCCCC"
}
```

response body(Code 200)

```json
{
  "id": 1,
  "name": "aaa",
  "description": "test marketA",
  "color": "#CCCCCCC"
}
```



#### DELETE  /MarketContext/

##### case 1

params

| Name            | value |
| :-------------- | :---- |
| marketContextId | 1     |

response 

```json
200 OK
```

##### case 2

params

| Name            | value |
| :-------------- | :---- |
| marketContextId | 3     |

response 

```json
404 Not found 
```

#### GET /MarketContext/{marketContextName}

##### case 1

params

| Name              | value |
| :---------------- | :---- |
| marketContextName | aaa   |

response (Code 200)

```json
{
  "id": 2,
  "name": "aaa",
  "description": "test market",
  "color": "#FAFAFA"
}
```

##### case 2

params

| Name                | value |
| :------------------ | :---- |
| marketContextNamebb | bbb   |

response 

```json
404 Not found 
```

### group-controller

#### GET /Group/

response body(Code 200)

```json
[
  {
    "id": 1,
    "name": "user",
    "description": "oadr user"
  }
]
```

#### POST /Group/

##### case1

request body

```json
{
  "id": 1,
  "name": "user",
  "description": "oadr user"
}
```

response body(Code 201)

```json
{
  "id": 1,
  "name": "user",
  "description": "oadr user"
}
```

##### case 2

request body

```json
{
  "id": 2,
  "name": "user",
  "description": "oadr user2"
}
```

response body(Code 406)

```json
406	
Error: Not Acceptable
```

#### PUT /Group/

##### case 1

request body

```json
  {
    "id": 1,
    "name": "user2",
    "description": "oadr vtn user"
  }
```

response body(Code 406)

```json
406	
Error: Not Acceptable
```

##### case 2

request body

```json
  {
    "id": 1,
    "name": "user",
    "description": "oadr vtn user"
  }
```

response body(Code 200)

```json
{
  "id": 1,
  "name": "user",
  "description": "oadr vtn user"
}
```

##### case 3

request body

```json
{
  "id": 3,
  "name": "user",
  "description": "oadr vtn user"
}
```

response body(Code 200)

```json
{
  "id": 1,
  "name": "user",
  "description": "oadr vtn user"
}
```



#### DELETE  /Group/{groupId}

##### case 1

params

| Name    | value |
| :------ | :---- |
| groupId | 1     |

response 

```json
200 OK
```

##### case 2

params

| Name    | value |
| :------ | :---- |
| groupId | 3     |

response 

```json
404 Not found 
```

#### GET /Group/{groupName}

##### case 1

params

| Name      | value   |
| :-------- | :------ |
| groupName | manager |

response (Code 200)

```json
{
  "id": 2,
  "name": "manager",
  "description": "oadr device manager"
}
```

##### case 2

params

| Name       | value |
| :--------- | :---- |
| GrouptName | aaa   |

response 

```json
404 Not found 
```

### ven-Controller

#### POST /Ven/

##### case1

request body

```json
{
  "username": "ven.oadr.com",
  "password": "ven.oadr.com",
  "authenticationType": "X509",
  "needCertificateGeneration": "",
  "commonName": "ven.oadr.com",
  "oadrName": "ven.oadr.com",
  "oadrProfil": "ven.oadr.com",
  "transport": "ven.oadr.com",
  "pushUrl": "https://vtn.oadr.com:8181/testvtn",
  "httpPullModel": true,
  "reportOnly": true,
  "xmlSignature": true,
  "marketContexts": [
    "aaa"
  ],
  "groups": [
    "user"
  ],
  "resources": [

  ]
}
```

response (Code 201)

The response is a file in .tar form,which includes ven footprint ,key, crt and ca.files.



#### GET /Ven/

response (Code 200)

```json
[
  {
    "username": "f3427ed82251c2bb5e54",
    "password": null,
    "authenticationType": "ROLE_VEN",
    "needCertificateGeneration": null,
    "commonName": null,
    "id": "1",
    "oadrName": "ven3.oadr.com",
    "oadrProfil": "2.0b",
    "transport": "simpleHttp",
    "pushUrl": "https://ven3.oadr.com:8083",
    "httpPullModel": false,
    "lastUpdateDatetime": null,
    "registrationId": "f3427ed82251c2bb5e542123b3a9-f44c-4370-a4cf-c002be02fdd7",
    "reportOnly": false,
    "xmlSignature": false
  },
  {
    "username": "b45a270a7a9992dac0fe",
    "password": null,
    "authenticationType": "X509",
    "needCertificateGeneration": null,
    "commonName": "ven.oadr.com",
    "id": "2",
    "oadrName": "ven.oadr.com",
    "oadrProfil": "ven.oadr.com",
    "transport": "ven.oadr.com",
    "pushUrl": "https://vtn.oadr.com:8181/testvtn",
    "httpPullModel": true,
    "lastUpdateDatetime": null,
    "registrationId": null,
    "reportOnly": true,
    "xmlSignature": true
  }
]
```

#### GET /Ven/{VenID}

##### case 1

params

| Name  |        value         |
| :---: | :------------------: |
| VenID | b45a270a7a9992dac0fe |

response (Code 200)

```json
{
  "username": "b45a270a7a9992dac0fe",
  "password": null,
  "authenticationType": "X509",
  "needCertificateGeneration": null,
  "commonName": "ven.oadr.com",
  "id": "2",
  "oadrName": "ven.oadr.com",
  "oadrProfil": "ven.oadr.com",
  "transport": "ven.oadr.com",
  "pushUrl": "https://vtn.oadr.com:8181/testvtn",
  "httpPullModel": true,
  "lastUpdateDatetime": null,
  "registrationId": null,
  "reportOnly": true,
  "xmlSignature": true
}
```

##### case 2

params

| Name  | value  |
| :---: | :----: |
| VenID | 123456 |

response (Code 404)

```json
404
Error: Not Found
```

#### POST /Ven/{VenID}

##### case 1

params

| Name  |        value         |
| :---: | :------------------: |
| VenID | b45a270a7a9992dac0fe |

request body

```json
{
  "name": "ven test",
  "pullFrequencySeconds": 10
}
```

response (Code 200)

```json
{
  "username": "b45a270a7a9992dac0fe",
  "password": null,
  "authenticationType": "X509",
  "needCertificateGeneration": null,
  "commonName": "ven test",
  "oadrName": "ven.oadr.com",
  "oadrProfil": "ven.oadr.com",
  "transport": "ven.oadr.com",
  "pushUrl": "https://vtn.oadr.com:8181/testvtn",
  "httpPullModel": true,
  "reportOnly": true,
  "xmlSignature": true,
  "marketContexts": null,
  "groups": null,
  "resources": null
}
```

##### case 2

params

| Name  | value  |
| :---: | :----: |
| VenID | 123456 |

request body

```json
{
  "name": "eroor ven test",
  "pullFrequencySeconds": 10
}
```

response (Code 404)

```json
404
Error: Not Found
```

#### GET /Ven/{venID}/resource

params

| Name  |        value         |
| :---: | :------------------: |
| VenID | b45a270a7a9992dac0fe |

response body (Code 200)

```json
[]
```

#### POST /Ven/{VenID}/resource

##### case 1

params

| Name  |        value         |
| :---: | :------------------: |
| VenID | b45a270a7a9992dac0fe |

request body

```json
{
  "id": 2,
  "name": "resource test VEN"
}
```

response (Code 200)

```json
{
  "id": 1,
  "name": "resource test VEN"
}
```

##### case 2

params

| Name  | value  |
| :---: | :----: |
| VenID | 123456 |

request body

```json
{
  "id": 1,
  "name": "resource test VEN"
}
```

response (Code 404)

```json
404
Error: Not Found
```

#### GET  /Ven/{VenID}/marketContext

##### case 1

params

| Name  |        value         |
| :---: | :------------------: |
| VenID | b45a270a7a9992dac0fe |

```json
[
  {
    "id": 2,
    "name": "bbb",
    "description": "test market",
    "color": "#FAFAFA"
  }
]
```

##### case 2

params

| Name  | value  |
| :---: | :----: |
| VenID | 123456 |


response (Code 404)

```json
404 Error: Not Found
```

#### POST /Ven/{VenID}/marketContext

##### case 1

params

|      Name       |        value         |
| :-------------: | :------------------: |
|      VenID      | b45a270a7a9992dac0fe |
| marketContextId |          2           |

response body

```json
200 OK
```



##### case 2

params

|      Name       |        value         |
| :-------------: | :------------------: |
|      VenID      | b45a270a7a9992dac0fe |
| marketContextId |          1           |


response (Code 404)

```json
404 Error: Not Found
```

##### case 3

params

|      Name       | value  |
| :-------------: | :----: |
|      VenID      | 123456 |
| marketContextId |   2    |


response (Code 404)

```json
404 Error: Not Found
```

##### case 4

params

|      Name       | value  |
| :-------------: | :----: |
|      VenID      | 123456 |
| marketContextId |   1    |


response (Code 404)

```json
404 Error: Not Found
```

#### GET  /Ven/{VenID}/group

##### case 1

params

| Name  |        value         |
| :---: | :------------------: |
| VenID | b45a270a7a9992dac0fe |

```json
[
  {
    "id": 1,
    "name": "user",
    "description": "oadr vtn user"
  }
]
```

##### case 2

params

| Name  | value  |
| :---: | :----: |
| VenID | 123456 |


response (Code 404)

```json
404 Error: Not Found
```

#### POST /Ven/{VenID}/group

##### case 1

params

|  Name   |        value         |
| :-----: | :------------------: |
|  VenID  | b45a270a7a9992dac0fe |
| groupId |          2           |

response body(Code 200)

```json
{
  "username": "f3427ed82251c2bb5e54",
  "password": null,
  "authenticationType": "ROLE_VEN",
  "needCertificateGeneration": null,
  "commonName": null,
  "oadrName": "ven3.oadr.com",
  "oadrProfil": "2.0b",
  "transport": "simpleHttp",
  "pushUrl": "https://ven3.oadr.com:8083",
  "httpPullModel": false,
  "reportOnly": false,
  "xmlSignature": false,
  "marketContexts": null,
  "groups": null,
  "resources": null
}
```



##### case 2

params

|      Name       |        value         |
| :-------------: | :------------------: |
|      VenID      | b45a270a7a9992dac0fe |
| marketContextId |          1           |


response (Code 404)

```json
404 Error: Not Found
```

##### case 3

params

|      Name       | value  |
| :-------------: | :----: |
|      VenID      | 123456 |
| marketContextId |   2    |


response (Code 404)

```json
404 Error: Not Found
```

##### case 4

params

|      Name       | value  |
| :-------------: | :----: |
|      VenID      | 123456 |
| marketContextId |   1    |


response (Code 404)

```json
404 Error: Not Found
```

#### 

#### POST /Ven/[venID}/cleanRegistration

##### case 1

params

| Name  |       value        |
| :---: | :----------------: |
| VenID | b45a270a7a9992dac0 |

response body

```json
200 OK
```



##### case 2

params

| Name  |        value         |
| :---: | :------------------: |
| VenID | b45a270a7a9992dac0fe |


response (Code 404)

```json
404 Error: Not Found
```

#### POST /Ven/search

**The values accepted for types are: [EVENT, MARKET_CONTEXT, GROUP, VEN, IS_REGISTERED]**

##### case 1

params

| Name | value |
| :--: | :---: |
| Page |   0   |
| size |   5   |

request body

```json
[
  {
    "type": "MARKET_CONTEXT",
    "value": "bbb"
  }
]
```

reponse body(Code 200)

```json
[
  {
    "username": "b45a270a7a9992dac0fe",
    "password": null,
    "authenticationType": "X509",
    "needCertificateGeneration": null,
    "commonName": "ven test",
    "id": "2",
    "oadrName": "ven.oadr.com",
    "oadrProfil": "ven.oadr.com",
    "transport": "ven.oadr.com",
    "pushUrl": "https://vtn.oadr.com:8181/testvtn",
    "httpPullModel": true,
    "lastUpdateDatetime": null,
    "registrationId": null,
    "reportOnly": true,
    "xmlSignature": true
  }
]
```

##### case 2

params

| Name | value |
| :--: | :---: |
| Page |   0   |
| size |   5   |

request body

```json
[
  {
    "type": "VEN",
    "value": "bbb"
  }
]
```

reponse body(Code 200)

```json
[]
```

##### case 3

params

| Name | value |
| :--: | :---: |
| Page |   0   |
| size |   5   |

request body

```json
[
  {
    "type": "username",
    "value": "11"
  }
]
```

reponse body(Code 400)

```json
{
  "timestamp": 1753857132689,
  "status": 400,
  "error": "Bad Request",
  "path": "/testvtn/Ven/search"
}
```

##### case 4

params

| Name | value |
| :--: | :---: |
| Page |   3   |
| size |   5   |

request body

```json
[
  {
    "type": "MARKET_CONTEXT",
    "value": "bbb"
  }
]
```

reponse body(Code 200)

```json
[]
```

#### DELETE /Ven/(venID}/resource/(resourceName}

##### case 1

params

|     Name     |        value         |
| :----------: | :------------------: |
|    venID     | b45a270a7a9992dac0fe |
| resourceName |  resource test VEN   |

response body

```json
200 OK
```

##### case 2

params

|     Name     |        value         |
| :----------: | :------------------: |
|    venID     | b45a270a7a9992dac0fe |
| resourceName |     bad resource     |

response (Code 404)

```json
404 Error: Not Found
```

#### DELETE /Ven/(venID}/resource/(resourceName}

##### case 1

params

| Name  |        value         |
| :---: | :------------------: |
| venID | f3427ed82251c2bb5e54 |

response body

```json
200 OK
```

### demand-response-controller

#### POST /DemandResponseEvent/

##### case 1

request body

```json
{
  "signals": [
    {
      "signalName": "SIMPLE",
      "signalType": "DELTA",
      "intervals": [
        {
          "value": 1,
          "duration": "PT5M"
        }
      ],
      "currentValue": 0,
      "itemBase": {
        "itemDescription": "desp",
        "itemUnits": "1",
        "siScaleCode": "2",
        "xmlType": "XMPP"
      },
      "targets": [
        {
          "targetType": "VEN",
          "targetId": "1f163ecbed8013941e85"
        }
      ]
    }
  ],
  "targets": [
    {
      "targetType": "VEN",
      "targetId": "1f163ecbed8013941e85"
    }
  ],
  "published": true,
  "descriptor": {
    "priority": 0,
    "marketContext": "aaa",
    "testEvent": true,
    "responseRequired": "ALWAYS",
    "vtnComment": "test VTN",
    "state": "ACTIVE",
    "oadrProfile": "OADR20A"
  },
  "activePeriod": {
    "start": 0,
    "duration": "PT10M",
    "notificationDuration": "PT10M",
    "toleranceDuration": "PT20M",
    "rampUpDuration": "PT10M",
    "recoveryDuration": "PT5M"
  },
  "baseline": {
    "intervals": [
      {
        "value": 0,
        "duration": "PT2M"
      }
    ],
    "start": 0,
    "duration": "PT20M",
    "baselineId": "1",
    "resourceId": [
      "1"
    ],
    "baselineName": "Base",
    "itemBase": {
      "itemDescription": "testing desp",
      "itemUnits": "2",
      "siScaleCode": "100",
      "xmlType": "XMPP"
    }
  }
}
```

response body(Code 201)

```json
{
  "signals": [
    {
      "signalName": "SIMPLE",
      "signalType": "DELTA",
      "intervals": [
        {
          "value": 1,
          "duration": "PT5M"
        }
      ],
      "currentValue": 0,
      "itemBase": {
        "itemDescription": "desp",
        "itemUnits": "1",
        "siScaleCode": "2",
        "xmlType": "XMPP"
      },
      "targets": [
        {
          "targetType": "VEN",
          "targetId": "1f163ecbed8013941e85"
        }
      ]
    }
  ],
  "targets": [
    {
      "targetType": "VEN",
      "targetId": "1f163ecbed8013941e85"
    }
  ],
  "published": true,
  "descriptor": {
    "priority": 0,
    "marketContext": "aaa",
    "testEvent": true,
    "responseRequired": "ALWAYS",
    "vtnComment": "test VTN",
    "state": "ACTIVE",
    "oadrProfile": "OADR20A",
    "modificationNumber": 0
  },
  "activePeriod": {
    "start": 0,
    "duration": "PT10M",
    "notificationDuration": "PT10M",
    "toleranceDuration": "PT20M",
    "rampUpDuration": "PT10M",
    "recoveryDuration": "PT5M"
  },
  "baseline": {
    "intervals": [
      {
        "value": 0,
        "duration": "PT2M"
      }
    ],
    "start": 0,
    "duration": "PT20M",
    "baselineId": "1",
    "resourceId": [
      "1"
    ],
    "baselineName": "Base",
    "itemBase": {
      "itemDescription": "testing desp",
      "itemUnits": "2",
      "siScaleCode": "100",
      "xmlType": "XMPP"
    }
  },
  "id": 1,
  "createdTimestamp": 1753938382738,
  "lastUpdateTimestamp": 1753938382738
}
```

##### case 2

request body

```json
{
  "signals": [
    {
      "signalName": "SIMPLE",
      "signalType": "DELTA",
      "intervals": [
        {
          "value": 1,
          "duration": "PT5M"
        }
      ],
      "currentValue": 0,
      "itemBase": {
        "itemDescription": "desp",
        "itemUnits": "1",
        "siScaleCode": "2",
        "xmlType": "XMPP"
      },
      "targets": [
        {
          "targetType": "VEN",
          "targetId": "1f163ecbed8013941e85"
        }
      ]
    }
  ],
  "targets": [
    {
      "targetType": "VEN",
      "targetId": "1f163ecbed8013941e85"
    }
  ],
  "published": true,
  "descriptor": {
    "priority": 0,
    "marketContext": "bbb",
    "testEvent": true,
    "responseRequired": "ALWAYS",
    "vtnComment": "test VTN",
    "state": "ACTIVE",
    "oadrProfile": "OADR20A"
  },
  "activePeriod": {
    "start": 0,
    "duration": "PT10M",
    "notificationDuration": "PT10M",
    "toleranceDuration": "PT20M",
    "rampUpDuration": "PT10M",
    "recoveryDuration": "PT5M"
  },
  "baseline": {
    "intervals": [
      {
        "value": 0,
        "duration": "PT2M"
      }
    ],
    "start": 0,
    "duration": "PT20M",
    "baselineId": "1",
    "resourceId": [
      "1"
    ],
    "baselineName": "Base",
    "itemBase": {
      "itemDescription": "testing desp",
      "itemUnits": "2",
      "siScaleCode": "100",
      "xmlType": "XMPP"
    }
  }
}
```

response body(code 400)

```json
{
  "timestamp": 1753938783199,
  "status": 400,
  "error": "Bad Request",
  "path": "/testvtn/DemandResponseEvent/"
}
```

TIPS:

validate errror [Field error in object 'demandResponseEventCreateDto' on field 'descriptor.marketContext': rejected value [bbb]; codes [field.must_exists.demandResponseEventCreateDto.descriptor.marketContext,field.must_exists.descriptor.marketContext,field.must_exists.marketContext,field.must_exists.java.lang.String,field.must_exists]; arguments []; default message [MarketContext must exists]] ]

#### POST /DemandResponseEvent/{id}/publish

params

| Name | value |
| :--: | :---: |
|  id  |   1   |

response body(Code 200)

```json
{
  "signals": [
    {
      "signalName": "SIMPLE",
      "signalType": "DELTA",
      "intervals": [
        {
          "value": 1,
          "duration": "PT5M"
        }
      ],
      "currentValue": 0,
      "itemBase": {
        "itemDescription": "desp",
        "itemUnits": "1",
        "siScaleCode": "2",
        "xmlType": "XMPP"
      },
      "targets": [
        {
          "targetType": "VEN",
          "targetId": "1f163ecbed8013941e85"
        }
      ]
    }
  ],
  "targets": [
    {
      "targetType": "VEN",
      "targetId": "1f163ecbed8013941e85"
    }
  ],
  "published": true,
  "descriptor": {
    "priority": 0,
    "marketContext": "aaa",
    "testEvent": true,
    "responseRequired": "ALWAYS",
    "vtnComment": "test VTN",
    "state": "ACTIVE",
    "oadrProfile": "OADR20A",
    "modificationNumber": 0
  },
  "activePeriod": {
    "start": 0,
    "duration": "PT10M",
    "notificationDuration": "PT10M",
    "toleranceDuration": "PT20M",
    "rampUpDuration": "PT10M",
    "recoveryDuration": "PT5M"
  },
  "baseline": {
    "intervals": [
      {
        "value": 0,
        "duration": "PT2M"
      }
    ],
    "start": 0,
    "duration": "PT20M",
    "baselineId": "1",
    "resourceId": [
      "1"
    ],
    "baselineName": "Base",
    "itemBase": {
      "itemDescription": "testing desp",
      "itemUnits": "2",
      "siScaleCode": "100",
      "xmlType": "XMPP"
    }
  },
  "id": 1,
  "createdTimestamp": 1753938382738,
  "lastUpdateTimestamp": 1753938382738
}
```

#### POST /DemandResponseEvent/{id}/cancel

params

| Name | value |
| :--: | :---: |
|  id  |   1   |

response body(Code 200)

```json
{
  "signals": [
    {
      "signalName": "SIMPLE",
      "signalType": "DELTA",
      "intervals": [
        {
          "value": 1,
          "duration": "PT5M"
        }
      ],
      "currentValue": 0,
      "itemBase": {
        "itemDescription": "desp",
        "itemUnits": "1",
        "siScaleCode": "2",
        "xmlType": "XMPP"
      },
      "targets": [
        {
          "targetType": "VEN",
          "targetId": "1f163ecbed8013941e85"
        }
      ]
    }
  ],
  "targets": [
    {
      "targetType": "VEN",
      "targetId": "1f163ecbed8013941e85"
    }
  ],
  "published": true,
  "descriptor": {
    "priority": 0,
    "marketContext": "aaa",
    "testEvent": true,
    "responseRequired": "ALWAYS",
    "vtnComment": "test VTN",
    "state": "CANCELLED",
    "oadrProfile": "OADR20A",
    "modificationNumber": 4
  },
  "activePeriod": {
    "start": 0,
    "duration": "PT10M",
    "notificationDuration": "PT10M",
    "toleranceDuration": "PT20M",
    "rampUpDuration": "PT10M",
    "recoveryDuration": "PT5M"
  },
  "baseline": {
    "intervals": [
      {
        "value": 0,
        "duration": "PT2M"
      }
    ],
    "start": 0,
    "duration": "PT20M",
    "baselineId": "1",
    "resourceId": [
      "1"
    ],
    "baselineName": "Base",
    "itemBase": {
      "itemDescription": "testing desp",
      "itemUnits": "2",
      "siScaleCode": "100",
      "xmlType": "XMPP"
    }
  },
  "id": 1,
  "createdTimestamp": 1753938382738,
  "lastUpdateTimestamp": 1753939670046
}
```

#### POST /DemandResponseEvent/{id}/active

params

| Name | value |
| :--: | :---: |
|  id  |   1   |

response body(Code 200)

```json
{
  "signals": [
    {
      "signalName": "SIMPLE",
      "signalType": "DELTA",
      "intervals": [
        {
          "value": 1,
          "duration": "PT5M"
        }
      ],
      "currentValue": 0,
      "itemBase": {
        "itemDescription": "desp",
        "itemUnits": "1",
        "siScaleCode": "2",
        "xmlType": "XMPP"
      },
      "targets": [
        {
          "targetType": "VEN",
          "targetId": "1f163ecbed8013941e85"
        }
      ]
    }
  ],
  "targets": [
    {
      "targetType": "VEN",
      "targetId": "1f163ecbed8013941e85"
    }
  ],
  "published": true,
  "descriptor": {
    "priority": 0,
    "marketContext": "aaa",
    "testEvent": true,
    "responseRequired": "ALWAYS",
    "vtnComment": "test VTN",
    "state": "CANCELLED",
    "oadrProfile": "OADR20A",
    "modificationNumber": 4
  },
  "activePeriod": {
    "start": 0,
    "duration": "PT10M",
    "notificationDuration": "PT10M",
    "toleranceDuration": "PT20M",
    "rampUpDuration": "PT10M",
    "recoveryDuration": "PT5M"
  },
  "baseline": {
    "intervals": [
      {
        "value": 0,
        "duration": "PT2M"
      }
    ],
    "start": 0,
    "duration": "PT20M",
    "baselineId": "1",
    "resourceId": [
      "1"
    ],
    "baselineName": "Base",
    "itemBase": {
      "itemDescription": "testing desp",
      "itemUnits": "2",
      "siScaleCode": "100",
      "xmlType": "XMPP"
    }
  },
  "id": 1,
  "createdTimestamp": 1753938382738,
  "lastUpdateTimestamp": 1753939670046
}
```

#### POST /DemandResponseEvent/{id}/search

params

| Name  | value |
| :---: | :---: |
| start |   1   |
|  end  |   1   |
| page  |   0   |
| size  |  10   |

request body

```json
[
  {
    "type": "MARKET_CONTEXT",  
    "value": "aaa"     
  }
]
```



response body(Code 200)

```json
[
  {
    "signals": [
      {
        "signalName": "SIMPLE",
        "signalType": "DELTA",
        "intervals": [
          {
            "value": 1,
            "duration": "PT5M"
          }
        ],
        "currentValue": 0,
        "itemBase": {
          "itemDescription": "desp",
          "itemUnits": "1",
          "siScaleCode": "2",
          "xmlType": "XMPP"
        },
        "targets": [
          {
            "targetType": "VEN",
            "targetId": "1f163ecbed8013941e85"
          }
        ]
      }
    ],
    "targets": [
      {
        "targetType": "VEN",
        "targetId": "1f163ecbed8013941e85"
      }
    ],
    "published": true,
    "descriptor": {
      "priority": 0,
      "marketContext": "aaa",
      "testEvent": true,
      "responseRequired": "ALWAYS",
      "vtnComment": "test VTN",
      "state": "ACTIVE",
      "oadrProfile": "OADR20A",
      "modificationNumber": 5
    },
    "activePeriod": {
      "start": 0,
      "duration": "PT10M",
      "notificationDuration": "PT10M",
      "toleranceDuration": "PT20M",
      "rampUpDuration": "PT10M",
      "recoveryDuration": "PT5M"
    },
    "baseline": {
      "intervals": [
        {
          "value": 0,
          "duration": "PT2M"
        }
      ],
      "start": 0,
      "duration": "PT20M",
      "baselineId": "1",
      "resourceId": [
        "1"
      ],
      "baselineName": "Base",
      "itemBase": {
        "itemDescription": "testing desp",
        "itemUnits": "2",
        "siScaleCode": "100",
        "xmlType": "XMPP"
      }
    },
    "id": 1,
    "createdTimestamp": 1753938382738,
    "lastUpdateTimestamp": 1753939670046
  }
]
```

#### 

#### GET /DemandResponseEvent/{id}

params

| Name | value |
| :--: | :---: |
|  id  |   1   |

response body(Code 200)

```json
{
  "signals": [
    {
      "signalName": "SIMPLE",
      "signalType": "DELTA",
      "intervals": [
        {
          "value": 1,
          "duration": "PT5M"
        }
      ],
      "currentValue": 0,
      "itemBase": {
        "itemDescription": "desp",
        "itemUnits": "1",
        "siScaleCode": "2",
        "xmlType": "XMPP"
      },
      "targets": [
        {
          "targetType": "VEN",
          "targetId": "1f163ecbed8013941e85"
        }
      ]
    }
  ],
  "targets": [
    {
      "targetType": "VEN",
      "targetId": "1f163ecbed8013941e85"
    }
  ],
  "published": true,
  "descriptor": {
    "priority": 0,
    "marketContext": "aaa",
    "testEvent": true,
    "responseRequired": "ALWAYS",
    "vtnComment": "test VTN",
    "state": "ACTIVE",
    "oadrProfile": "OADR20A",
    "modificationNumber": 0
  },
  "activePeriod": {
    "start": 0,
    "duration": "PT10M",
    "notificationDuration": "PT10M",
    "toleranceDuration": "PT20M",
    "rampUpDuration": "PT10M",
    "recoveryDuration": "PT5M"
  },
  "baseline": {
    "intervals": [
      {
        "value": 0,
        "duration": "PT2M"
      }
    ],
    "start": 0,
    "duration": "PT20M",
    "baselineId": "1",
    "resourceId": [
      "1"
    ],
    "baselineName": "Base",
    "itemBase": {
      "itemDescription": "testing desp",
      "itemUnits": "2",
      "siScaleCode": "100",
      "xmlType": "XMPP"
    }
  },
  "id": 1,
  "createdTimestamp": 1753938382738,
  "lastUpdateTimestamp": 1753938382738
}
```

#### PUT /DemandResponseEvent/{id}

##### case 1

params



| Name | value |
| :--: | :---: |
|  id  |   1   |

request body

```json
{
  "signals": [
    {
      "signalName": "SIMPLE",
      "signalType": "DELTA",
      "intervals": [
        {
          "value": 1,
          "duration": "PT5M"
        }
      ],
      "currentValue": 0,
      "itemBase": {
        "itemDescription": "desp",
        "itemUnits": "1",
        "siScaleCode": "2",
        "xmlType": "XMPP"
      },
      "targets": [
        {
          "targetType": "VEN",
          "targetId": "1f163ecbed8013941e85"
        }
      ]
    }
  ],
  "targets": [
    {
      "targetType": "VEN",
      "targetId": "1f163ecbed8013941e85"
    }
  ],
  "published": true,
  "descriptor": {
    "priority": 0,
    "marketContext": "aaa",
    "testEvent": true,
    "responseRequired": "ALWAYS",
    "vtnComment": "test VTN",
    "state": "ACTIVE",
    "oadrProfile": "OADR20B"
  },
  "activePeriod": {
    "start": 0,
    "duration": "PT10M",
    "notificationDuration": "PT10M",
    "toleranceDuration": "PT20M",
    "rampUpDuration": "PT10M",
    "recoveryDuration": "PT5M"
  },
  "baseline": {
    "intervals": [
      {
        "value": 0,
        "duration": "PT2M"
      }
    ],
    "start": 0,
    "duration": "PT20M",
    "baselineId": "1",
    "resourceId": [
      "1"
    ],
    "baselineName": "Base",
    "itemBase": {
      "itemDescription": "testing desp",
      "itemUnits": "2",
      "siScaleCode": "100",
      "xmlType": "XMPP"
    }
  }
}
```

response body(Code 201)

```json
{
  "signals": [
    {
      "signalName": "SIMPLE",
      "signalType": "DELTA",
      "intervals": [
        {
          "value": 1,
          "duration": "PT5M"
        }
      ],
      "currentValue": 0,
      "itemBase": {
        "itemDescription": "desp",
        "itemUnits": "1",
        "siScaleCode": "2",
        "xmlType": "XMPP"
      },
      "targets": [
        {
          "targetType": "VEN",
          "targetId": "1f163ecbed8013941e85"
        }
      ]
    }
  ],
  "targets": [
    {
      "targetType": "VEN",
      "targetId": "1f163ecbed8013941e85"
    }
  ],
  "published": true,
  "descriptor": {
    "priority": 0,
    "marketContext": "aaa",
    "testEvent": true,
    "responseRequired": "ALWAYS",
    "vtnComment": "test VTN",
    "state": "ACTIVE",
    "oadrProfile": "OADR20A",
    "modificationNumber": 2
  },
  "activePeriod": {
    "start": 0,
    "duration": "PT10M",
    "notificationDuration": "PT10M",
    "toleranceDuration": "PT20M",
    "rampUpDuration": "PT10M",
    "recoveryDuration": "PT5M"
  },
  "baseline": {
    "intervals": [
      {
        "value": 0,
        "duration": "PT2M"
      }
    ],
    "start": 0,
    "duration": "PT20M",
    "baselineId": "1",
    "resourceId": [
      "1"
    ],
    "baselineName": "Base",
    "itemBase": {
      "itemDescription": "testing desp",
      "itemUnits": "2",
      "siScaleCode": "100",
      "xmlType": "XMPP"
    }
  },
  "id": 1,
  "createdTimestamp": 1753938382738,
  "lastUpdateTimestamp": 1753939434247
}
```

##### case 2

request body

```json
{
  "signals": [
    {
      "signalName": "SIMPLE",
      "signalType": "DELTA",
      "intervals": [
        {
          "value": 1,
          "duration": "PT5M"
        }
      ],
      "currentValue": 0,
      "itemBase": {
        "itemDescription": "desp",
        "itemUnits": "1",
        "siScaleCode": "2",
        "xmlType": "XMPP"
      },
      "targets": [
        {
          "targetType": "VEN",
          "targetId": "1f163ecbed8013941e85"
        }
      ]
    }
  ],
  "targets": [
    {
      "targetType": "VEN",
      "targetId": "1f163ecbed8013941e85"
    }
  ],
  "published": true,
  "descriptor": {
    "priority": 0,
    "marketContext": "bbb",
    "testEvent": true,
    "responseRequired": "ALWAYS",
    "vtnComment": "test VTN",
    "state": "ACTIVE",
    "oadrProfile": "OADR20B"
  },
  "activePeriod": {
    "start": 0,
    "duration": "PT10M",
    "notificationDuration": "PT10M",
    "toleranceDuration": "PT20M",
    "rampUpDuration": "PT10M",
    "recoveryDuration": "PT5M"
  },
  "baseline": {
    "intervals": [
      {
        "value": 0,
        "duration": "PT2M"
      }
    ],
    "start": 0,
    "duration": "PT20M",
    "baselineId": "1",
    "resourceId": [
      "1"
    ],
    "baselineName": "Base",
    "itemBase": {
      "itemDescription": "testing desp",
      "itemUnits": "2",
      "siScaleCode": "100",
      "xmlType": "XMPP"
    }
  }
}
```

response body(code 200)

```json
{
  "signals": [
    {
      "signalName": "SIMPLE",
      "signalType": "DELTA",
      "intervals": [
        {
          "value": 1,
          "duration": "PT5M"
        }
      ],
      "currentValue": 0,
      "itemBase": {
        "itemDescription": "desp",
        "itemUnits": "1",
        "siScaleCode": "2",
        "xmlType": "XMPP"
      },
      "targets": [
        {
          "targetType": "VEN",
          "targetId": "1f163ecbed8013941e85"
        }
      ]
    }
  ],
  "targets": [
    {
      "targetType": "VEN",
      "targetId": "1f163ecbed8013941e85"
    }
  ],
  "published": true,
  "descriptor": {
    "priority": 0,
    "marketContext": "aaa",
    "testEvent": true,
    "responseRequired": "ALWAYS",
    "vtnComment": "test VTN",
    "state": "ACTIVE",
    "oadrProfile": "OADR20A",
    "modificationNumber": 3
  },
  "activePeriod": {
    "start": 0,
    "duration": "PT10M",
    "notificationDuration": "PT10M",
    "toleranceDuration": "PT20M",
    "rampUpDuration": "PT10M",
    "recoveryDuration": "PT5M"
  },
  "baseline": {
    "intervals": [
      {
        "value": 0,
        "duration": "PT2M"
      }
    ],
    "start": 0,
    "duration": "PT20M",
    "baselineId": "1",
    "resourceId": [
      "1"
    ],
    "baselineName": "Base",
    "itemBase": {
      "itemDescription": "testing desp",
      "itemUnits": "2",
      "siScaleCode": "100",
      "xmlType": "XMPP"
    }
  },
  "id": 1,
  "createdTimestamp": 1753938382738,
  "lastUpdateTimestamp": 1753939670046
}
```

#### DELETE /DemandResponseEvent/{id}

##### case 1

params



| Name | value |
| :--: | :---: |
|  id  |   1   |

response body(Code 200)

```json
200 OK
```

#### GET /DemandResponseEvent/{id)/venResponse

params



| Name | value |
| :--: | :---: |
|  id  |   1   |

response body(code 200)

```json
[]
```

#### GET /DemandResponseEvent/{id)/venResponse/{username}

params



|   Name   |        value         |
| :------: | :------------------: |
|    id    |          1           |
| username | 1f163ecbed8013941e85 |

response body(code 404)

```json
404 error not found 
```



### oadr-20b-ven-controller

#### POST /Ven/[venID}/report_action/sendRegister

##### case 1

params

| Name |        value         |
| :--: | :------------------: |
|  id  | f3427ed82251c2bb5e54 |

response body

```json
200 OK
```

##### case 2

params

| Name  |        value         |
| :---: | :------------------: |
| VenId | 1f163ecbed8013941e85 |

response body

```json
406	Not Acceptable
```

#### POST /Ven/[venID}/report_action/cancel

##### case 1

params

|      Name       |        value         |
| :-------------: | :------------------: |
|      VenId      | f3427ed82251c2bb5e54 |
| reportRequestId |          0           |

response body

```json
200 OK
```

##### case 2

params

|      Name       |        value         |
| :-------------: | :------------------: |
|       id        | 1f163ecbed8013941e85 |
| reportRequestId |          0           |

response body

```json
200 0k
```

##### case 3

params

|      Name       |        value         |
| :-------------: | :------------------: |
|       id        | 1f163ecbed8013941e85 |
| reportRequestId |          1           |

response body

```json
200 0k
```

##### case 4

params

|      Name       |        value         |
| :-------------: | :------------------: |
|      VenId      | f3427ed82251c2bb5e54 |
| reportRequestId |          1           |

response body

```json
200 OK
```

##### case 5

params

|      Name       |        value        |
| :-------------: | :-----------------: |
|      VenId      | f3427ed82251c2bb5e5 |
| reportRequestId |          0          |

response body(Code 406)

```json
{
  "timestamp": 1753926454732,
  "status": 406,
  "error": "Not Acceptable",
  "path": "/testvtn/Ven/f3427ed82251c2bb5e5/report_action/cancel"
}
```

#### POST /Ven/{venID}/report/requested/specifier

##### case 1

params

| Name  |        value         |
| :---: | :------------------: |
| VenId | f3427ed82251c2bb5e54 |

request body

```json
{
  "reportSpecifierId": [
    "1"
  ],
  "reportRequestId": [
    "0"
  ],
  "rid": [
    "1"
  ]
}
```

response body(code 200)

```json
[]
```

##### case 2

params

| Name  |        value         |
| :---: | :------------------: |
| VenId | 1f163ecbed8013941e84 |

request body

```json
{
  "reportSpecifierId": [
    "1"
  ],
  "reportRequestId": [
    "1"
  ],
  "rid": [
    "1"
  ]
}
```

response body(code 406)

```json
{
  "timestamp": 1753863447055,
  "status": 406,
  "error": "Not Acceptable",
  "path": "/testvtn/Ven/1f163ecbed8013941e84/report/requested/specifier"
}
```

#### POST/Ven/[venID}/report/available/description/subscribe

##### case 1

params

| Name  |        value         |
| :---: | :------------------: |
| VenId | 79dcc535d81f90ad26be |

request body

```json
[
  {
    "reportSpecifierId": "1",
    "reportRequestId": "0",
    "rid": {
      "additionalProp1": true,
      "additionalProp2": true,
      "additionalProp3": true
    },
    "granularity": "PT0M",
    "reportBackDuration": "PT0M"
  }
]
```

response body(code 200)

```json
[]
```

##### case 2

params

| Name  |        value         |
| :---: | :------------------: |
| VenId | 1f163ecbed8013941e84 |

request body

```json
[
  {
    "reportSpecifierId": "1",
    "reportRequestId": "1",
    "rid": {
      "additionalProp1": true,
      "additionalProp2": true,
      "additionalProp3": true
    },
    "granularity": "PT0M",
    "reportBackDuration": "PT0M"
  }
]
```

response body(code 406)

```json
{
  "timestamp": 1753863447055,
  "status": 406,
  "error": "Not Acceptable",
  "path": "/testvtn/Ven/1f163ecbed8013941e84/report/requested/specifier"
}
```



#### POST/Ven/IvenID}/report/requested/cancelSubscription

##### case 1

params

| Name  |        value         |
| :---: | :------------------: |
| VenId | 1f163ecbed8013941e85 |

request body

```json
[
  {
    "reportSpecifierId": "1",
    "reportRequestId": "1",
    "rid": {
      "additionalProp1": true,
      "additionalProp2": true,
      "additionalProp3": true
    },
    "granularity": "PT0M",
    "reportBackDuration": "PT0M"
  }
]
```

response body(code 200)

```json
[]
```

##### case 2

params

| Name  |        value         |
| :---: | :------------------: |
| VenId | 1f163ecbed8013941e84 |

request body

```json
{
  "reportSpecifierId": [
    "1"
  ],
  "reportRequestId": [
    "1"
  ],
  "rid": [
    "1"
  ]
}
```

response body(code 406)

```json
{
  "timestamp": 1753863447055,
  "status": 406,
  "error": "Not Acceptable",
  "path": "/testvtn/Ven/1f163ecbed8013941e84/report/requested/specifier"
}
```

#### POST /Ven/[venID}/report_action/specifier

##### case 1

params

| Name  |        value         |
| :---: | :------------------: |
| VenId | 1f163ecbed8013941e85 |

request body

```json
{
  "reportSpecifierId": [
    "1"
  ],
  "reportRequestId": [
    "1"
  ],
  "rid": [
    "1"
  ]
}
```

response body(code 200)

```json
[]
```

##### case 2

params

| Name  |        value         |
| :---: | :------------------: |
| VenId | 1f163ecbed8013941e84 |

request body

```json
{
  "reportSpecifierId": [
    "1"
  ],
  "reportRequestId": [
    "1"
  ],
  "rid": [
    "1"
  ]
}
```

response body(code 406)

```json
{
  "timestamp": 1753863447055,
  "status": 406,
  "error": "Not Acceptable",
  "path": "/testvtn/Ven/1f163ecbed8013941e84/report/requested/specifier"
}
```

#### POST /Ven/(venID}/report/requested/cancelSubscription

##### case 1

params

|      Name       |        value         |
| :-------------: | :------------------: |
|      VenId      | 1f163ecbed8013941e85 |
| reportRequestId |          1           |

response body(code 200)

```json
200 OK
```

##### case 2

params

|      Name       |        value         |
| :-------------: | :------------------: |
|      VenId      | 1f163ecbed8013941e85 |
| reportRequestId |          0           |

response body(code 500)

```json
{
  "timestamp": 1753868283033,
  "status": 500,
  "error": "Internal Server Error",
  "path": "/testvtn/Ven/1f163ecbed8013941e85/report/requested/cancelSubscription"
}
```

#### POST /Ven/{venID}/report/available/description/request

##### case 1

params

| Name  |        value         |
| :---: | :------------------: |
| VenId | f3427ed82251c2bb5e54 |

request body

```json
[
  {
    "reportSpecifierId": "1",
    "rid": [
      "1"
    ],
    "start": 0,
    "end": 30
  }
]
```

response body(code 200)

```json
200 OK
```

##### case 2

params

| Name  |        value         |
| :---: | :------------------: |
| VenId | 1f163ecbed8013941e84 |

request body

```json
[
  {
    "reportSpecifierId": "1",
    "rid": [
      "1"
    ],
    "start": 0,
    "end": 30
  }
]
```

response body(code 406)

```json
{
  "timestamp": 1753866002437,
  "status": 406,
  "error": "Not Acceptable",
  "path": "/testvtn/Ven/%201f163ecbed8013941e84/report/available/description/request"
}
```

#### POST /Ven/(venID}/registerparty/requestReregistration

##### case 1

params

| Name  |        value         |
| :---: | :------------------: |
| VenId | 1f163ecbed8013941e85 |

response body(code 200)

```json
200 OK
```

##### case 2

params

| Name  | value  |
| :---: | :----: |
| VenId | 123456 |

response body(code 406)

```json
{
  "timestamp": 1753866626158,
  "status": 406,
  "error": "Not Acceptable",
  "path": "/testvtn/Ven/1f163ecbed8013941e8/registerparty/requestReregistration"
}
```

#### POST /Ven/(venID}/registerparty/cancelPartyRegistration

##### case 1

params

| Name  |        value         |
| :---: | :------------------: |
| VenId | 1f163ecbed8013941e85 |

response body(code 200)

```json
200 OK
```

##### case 2

params

| Name  | value  |
| :---: | :----: |
| VenId | 123456 |

response body(code 406)

```json
{
  "timestamp": 1753866626158,
  "status": 406,
  "error": "Not Acceptable",
  "path": "/testvtn/Ven/1f163ecbed8013941e8/registerparty/requestReregistration"
}
```

#### GET /Ven/[venID}/report/requested

##### case 1

params

|       Name        |        value         |
| :---------------: | :------------------: |
|       VenId       | f3427ed82251c2bb5e54 |
| reportSpecifierId |          0           |
|  reportRequestId  |          0           |

response body(code 200)

```json
[]
```

##### case 2

params

|       Name        |        value         |
| :---------------: | :------------------: |
|       VenId       | f3427ed82251c2bb5e54 |
| reportSpecifierId |          1           |
|  reportRequestId  |          0           |

response body(code 200)

```json
[
  {
    "id": 0,
    "reportRequestId": "0",
    "reportSpecifierId": "0",
    "granularity": "PT0M",
    "reportBackDuration": "10M",
    "start": 0,
    "end": 0,
    "acked": true,
    "createdDatetime": 1753929857,
    "venId": "f3427ed82251c2bb5e54",
    "requestorUsername": "f3427ed82251c2bb5e54"
  }
]
```

#### GET /Ven/{VenID}/opt

params

|     Name      |        value         |
| :-----------: | :------------------: |
|     VenId     | f3427ed82251c2bb5e54 |
|     start     |                      |
|      end      |                      |
| marketContext |                      |

response body(code 200)

```json
[
  {
    "id": 1,
    "venId": "f3427ed82251c2bb5e54",
    "marketContext": null,
    "resourceId": null,
    "eventId": null,
    "optId": "0",
    "start": 1753924144829,
    "end": 1754010544829,
    "opt": "OPT_OUT"
  }
]
```

#### GET /Ven/{venID}/opt/resource/{resourceName}

params

|     Name     |        value         |
| :----------: | :------------------: |
|    VenID     | f3427ed82251c2bb5e54 |
| resourceName |         ven          |

response body(code 406)

```json
{
  "timestamp": 1753943427188,
  "status": 406,
  "error": "Not Acceptable",
  "path": "/testvtn/Ven/f3427ed82251c2bb5e54/opt/resource/ven"
}
```

### role-controller

#### POST /Role/{username}

params

|   Name   |        value         |
| :------: | :------------------: |
| username | f3427ed82251c2bb5e54 |

response body(code 200)

```json
[
  "ROLE_VEN"
]
```



### account-Controller

#### POST /Account/user

request body

```json
{
  "username": "admin",
  "password": "admin",
  "authenticationType": "ROLE_ADMIN",
  "needCertificateGeneration": "true",
  "commonName": "administrator",
  "roles": [
    "ROLE_ADMIN",
      "VEN",
      "VTN"
  ]
}
```

response body(Code 201)

The response is a file in .tar form,which includes ven footprint ,key, crt and ca.files.

#### GET /Account/user

response body

```json
[
  {
    "username": "310643d26be2ea217a4a",
    "password": null,
    "authenticationType": "ROLE_ADMIN",
    "needCertificateGeneration": null,
    "commonName": "administrator",
    "id": "3",
    "roles": [
      "ROLE_ADMIN",
      "VEN",
      "VTN"
    ],
    "email": null
  }
]
```

#### POST /Account/app

request body

```json
{
  "username": "vtn app",
  "password": "vtn app",
  "authenticationType": "VTN",
  "needCertificateGeneration": "false",
  "commonName": "VTN",
  "roles": [
      "VTN"
  ]
}
```

response body(Code 201)

The response is a file in .tar form,which includes ven footprint ,key, crt and ca.files.

#### GET /Account/app

response body

```json
[
  {
    "username": "b18a41ea3ed8c7682454",
    "password": null,
    "authenticationType": "VTN",
    "needCertificateGeneration": null,
    "commonName": "VTN",
    "id": "4",
    "roles": [
      "VTN"
    ]
  }
]
```

#### GET /Account

response body

```json
200 ok
```

#### DELETE /Account/user/{username}

##### case 1

params

|   Name   | value |
| :------: | :---: |
| username | admin |

response body(code 404)

```json
404 not Found
```

##### case 2

params

|   Name   |        value         |
| :------: | :------------------: |
| username | 310643d26be2ea217a4a |

response body(code 200)

```json
200 OK
```

#### DELETE /Account/app/{username}

##### case 1

params

|   Name   | value |
| :------: | :---: |
| username |  VTN  |

response body(code 404)

```json
404 not Found
```

##### case 2

params

|   Name   |        value         |
| :------: | :------------------: |
| username | b18a41ea3ed8c7682454 |

response body(code 200)

```json
200 OK
```

### oadr-20b-vtn-controller

#### GET /Vtn/report/requested

response body(code 200)

```json
[]
```

#### GET /Vtn/report/available

response body(code 200)

```json
[]
```

#### GET /Vtn/report/available/{reportSpecifierId}

##### case 1

params

|       Name        |         value          |
| :---------------: | :--------------------: |
| reportSpecifierId | 0013A20040980FAE_USAGE |

Response body(Code 406)

```json
{
  "timestamp": 1753945061050,
  "status": 406,
  "error": "Not Acceptable",
  "path": "/testvtn/Vtn/report/available/b18a41ea3ed8c7682454"
}
```

##### case 2

params

|       Name        |        value         |
| :---------------: | :------------------: |
| reportSpecifierId | b18a41ea3ed8c7682454 |

Response body(Code 406)

```json
{
  "timestamp": 1753945061050,
  "status": 406,
  "error": "Not Acceptable",
  "path": "/testvtn/Vtn/report/available/b18a41ea3ed8c7682454"
}
```

#### GET /Vtn/configuration

response body

```json
{
  "vtnId": "18547bdbc1e94b8bf798",
  "supportPush": true,
  "supportUnsecuredHttpPush": true,
  "pullFrequencySeconds": 10,
  "port": 8181,
  "contextPath": "/testvtn",
  "host": null,
  "oadrVersion": "OpenADR 20b",
  "supportCertificateGeneration": true,
  "xsdValidation": true,
  "xmlSignatureReplayProtectSecond": 1200,
  "saveVenDate": false
}
```

### report-Controller

#### GET /Report/available/search

##### case1

params

|       Name        | value |
| :---------------: | :---: |
|       VenID       |       |
| reportSpecifierId |       |

response body(Code 200)

```json
[]
```

##### case 2

params

|       Name        |         value          |
| :---------------: | :--------------------: |
|       VenID       |  f3427ed82251c2bb5e54  |
| reportSpecifierId | 0013A20040980FAE_USAGE |

response body(Code 200)

```json
[
  {
    "id": 1,
    "reportId": null,
    "reportSpecifierId": "0013A20040980FAE_USAGE",
    "reportRequestId": null,
    "reportName": "METADATA_TELEMETRY_USAGE",
    "start": null,
    "duration": null,
    "createdDatetime": 1577836800000,
    "venId": "f3427ed82251c2bb5e54"
  }
][]
```



#### GET /Report/available/description/search

response body

```json
[
  {
    "id": 1,
    "rid": "Current Temp",
    "reportType": "USAGE",
    "readingType": "X_NOT_APPLICABLE",
    "samplingRate": {
      "oadrMaxPeriod": "PT1M",
      "oadrMinPeriod": "PT10S",
      "oadrOnChange": false
    },
    "itemBase": {
      "itemDescription": "temperature",
      "itemUnits": "celsius",
      "siScaleCode": "none",
      "xmlType": "TemperatureType"
    },
    "eiDatasource": [],
    "eiSubject": [],
    "venId": "f3427ed82251c2bb5e54",
    "reportSpecifierId": "0013A20040980FAE_USAGE"
  },
  {
    "id": 2,
    "rid": "Heat Temp Setting",
    "reportType": "SET_POINT",
    "readingType": "X_NOT_APPLICABLE",
    "samplingRate": {
      "oadrMaxPeriod": "PT1M",
      "oadrMinPeriod": "PT10S",
      "oadrOnChange": false
    },
    "itemBase": {
      "itemDescription": "temperature",
      "itemUnits": "celsius",
      "siScaleCode": "none",
      "xmlType": "TemperatureType"
    },
    "eiDatasource": [],
    "eiSubject": [],
    "venId": "f3427ed82251c2bb5e54",
    "reportSpecifierId": "0013A20040980FAE_USAGE"
  },
  {
    "id": 3,
    "rid": "Cool Temp Setting",
    "reportType": "SET_POINT",
    "readingType": "X_NOT_APPLICABLE",
    "samplingRate": {
      "oadrMaxPeriod": "PT1M",
      "oadrMinPeriod": "PT10S",
      "oadrOnChange": false
    },
    "itemBase": {
      "itemDescription": "temperature",
      "itemUnits": "celsius",
      "siScaleCode": "none",
      "xmlType": "TemperatureType"
    },
    "eiDatasource": [],
    "eiSubject": [],
    "venId": "f3427ed82251c2bb5e54",
    "reportSpecifierId": "0013A20040980FAE_USAGE"
  },
  {
    "id": 4,
    "rid": "HVAC Mode Setting",
    "reportType": "OPERATING_STATE",
    "readingType": "X_NOT_APPLICABLE",
    "samplingRate": {
      "oadrMaxPeriod": "PT1M",
      "oadrMinPeriod": "PT10S",
      "oadrOnChange": false
    },
    "itemBase": {
      "itemDescription": "HVAC settings",
      "itemUnits": "0=OFF,1=HEAT,2=COOL,3=AUTO",
      "siScaleCode": "none",
      "xmlType": "BaseUnitType"
    },
    "eiDatasource": [],
    "eiSubject": [],
    "venId": "f3427ed82251c2bb5e54",
    "reportSpecifierId": "0013A20040980FAE_USAGE"
  },
  {
    "id": 5,
    "rid": "Current HVAC Mode",
    "reportType": "OPERATING_STATE",
    "readingType": "X_NOT_APPLICABLE",
    "samplingRate": {
      "oadrMaxPeriod": "PT1M",
      "oadrMinPeriod": "PT10S",
      "oadrOnChange": false
    },
    "itemBase": {
      "itemDescription": "HVAC states",
      "itemUnits": "0=OFF,1=HEAT,2=COOL",
      "siScaleCode": "none",
      "xmlType": "BaseUnitType"
    },
    "eiDatasource": [],
    "eiSubject": [],
    "venId": "f3427ed82251c2bb5e54",
    "reportSpecifierId": "0013A20040980FAE_USAGE"
  },
  {
    "id": 6,
    "rid": "Fan Mode Setting",
    "reportType": "OPERATING_STATE",
    "readingType": "X_NOT_APPLICABLE",
    "samplingRate": {
      "oadrMaxPeriod": "PT1M",
      "oadrMinPeriod": "PT10S",
      "oadrOnChange": false
    },
    "itemBase": {
      "itemDescription": "FAN settings",
      "itemUnits": "0=OFF,1=ON,2=AUTO",
      "siScaleCode": "none",
      "xmlType": "BaseUnitType"
    },
    "eiDatasource": [],
    "eiSubject": [],
    "venId": "f3427ed82251c2bb5e54",
    "reportSpecifierId": "0013A20040980FAE_USAGE"
  },
  {
    "id": 7,
    "rid": "Current Hold Mode",
    "reportType": "OPERATING_STATE",
    "readingType": "X_NOT_APPLICABLE",
    "samplingRate": {
      "oadrMaxPeriod": "PT1M",
      "oadrMinPeriod": "PT10S",
      "oadrOnChange": false
    },
    "itemBase": {
      "itemDescription": "HOLD states",
      "itemUnits": "0=none,1=temporary,2=permanent",
      "siScaleCode": "none",
      "xmlType": "BaseUnitType"
    },
    "eiDatasource": [],
    "eiSubject": [],
    "venId": "f3427ed82251c2bb5e54",
    "reportSpecifierId": "0013A20040980FAE_USAGE"
  },
  {
    "id": 8,
    "rid": "Current Away Mode",
    "reportType": "OPERATING_STATE",
    "readingType": "X_NOT_APPLICABLE",
    "samplingRate": {
      "oadrMaxPeriod": "PT1M",
      "oadrMinPeriod": "PT10S",
      "oadrOnChange": false
    },
    "itemBase": {
      "itemDescription": "Away states",
      "itemUnits": "0=OFF,1=ON",
      "siScaleCode": "none",
      "xmlType": "BaseUnitType"
    },
    "eiDatasource": [],
    "eiSubject": [],
    "venId": "f3427ed82251c2bb5e54",
    "reportSpecifierId": "0013A20040980FAE_USAGE"
  },
  {
    "id": 9,
    "rid": "Current Humidity",
    "reportType": "USAGE",
    "readingType": "X_NOT_APPLICABLE",
    "samplingRate": {
      "oadrMaxPeriod": "PT1M",
      "oadrMinPeriod": "PT10S",
      "oadrOnChange": false
    },
    "itemBase": {
      "itemDescription": "Current Humidity",
      "itemUnits": "percent",
      "siScaleCode": "none",
      "xmlType": "BaseUnitType"
    },
    "eiDatasource": [],
    "eiSubject": [],
    "venId": "f3427ed82251c2bb5e54",
    "reportSpecifierId": "0013A20040980FAE_USAGE"
  },
  {
    "id": 10,
    "rid": "Status",
    "reportType": "X_RESOURCE_STATUS",
    "readingType": "X_NOT_APPLICABLE",
    "samplingRate": {
      "oadrMaxPeriod": "PT1M",
      "oadrMinPeriod": "PT10S",
      "oadrOnChange": false
    },
    "itemBase": null,
    "eiDatasource": [],
    "eiSubject": [],
    "venId": "f3427ed82251c2bb5e54",
    "reportSpecifierId": "0013A20040980FAE_STATUS"
  }
]
```

