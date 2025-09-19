#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username postgres --dbname "postgres" <<-EOSQL
    CREATE USER "oadr-vtn20b" WITH ENCRYPTED PASSWORD 'supersecure';
    CREATE DATABASE "oadr-vtn20b" OWNER "oadr-vtn20b";
    GRANT ALL PRIVILEGES ON DATABASE "oadr-vtn20b" TO "oadr-vtn20b";
EOSQL