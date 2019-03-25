# Water Quality NWIS lookup ETL from NatDB to WQP NWIS SCHEMA

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/8585450f91a543ae8b7e23ea037ff991)](https://www.codacy.com/app/usgs_wma_dev/etl-nwis-lookups?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=NWQMC/etl-nwis-lookups&amp;utm_campaign=Badge_Grade)

This repo contains a spring batch application which runs the NatDB to WQP NWIS schema
ETL. At the moment it still contains the sql script to ETL from NEMI to the WQP crosswalk table. Eventually this will be in a separate repo.

## Local Configuration
In order to run locally, you will need connection information to the NatDB database. For the WQP NWIS schema, you can use the docker commands in schema-nwis-ws-star to spin up a local postgres database.

You will need to create an application.yml file containing the following:
```
NWIS_WS_STAR_HOST: <postgres_nwis_ws_star_host>
NWIS_WS_STAR_PORT: <postgres_nwis_ws_star_port>
NWIS_WS_STAR_DB: <nwis_ws_star_db>
NWIS_WS_STAR_USERNAME: <nwis_ws_star>
NWIS_WS_STAR_PASSWORD: <nwis_ws_sta>

NATDB_HOST: <oracle_natdb_host>
NATDB_PORT: <oracle_natdb_port>
NATDB_NWISRA_DB: <natdb_db_name>
NATDB_USERNAME: <natdb_username>
NATDB_PASSWORD: <natdb_password>
```

You can then run the ETL with the following:
```% mvn spring-boot:run```

The project is currently set up to run the job every time the command is launched.

This project still includes the sql script for ETLing from NEMI to WQP's NWIS_WS_STAR schema. Plan is for this to go into a separate repo. 