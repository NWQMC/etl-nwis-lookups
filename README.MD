# Water Quality NWIS lookup ETL from NatDB to WQP NWIS SCHEMA

This repo contains a spring batch application which runs the NatDB to WQP NWIS schema
ETL. At the moment it still contains the sql script to ETL from NEMI to the WQP crosswalk table. Eventually this will be in a separate repo.

## Local Configuration
In order to run locally, you will need connection information to the NatDB database. For the WQP NWIS schema, you can use the docker commands in schema-nwis-ws-star to spin up a local postgres database.

