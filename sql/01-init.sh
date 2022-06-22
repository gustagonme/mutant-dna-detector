#! /bin/bash
set -e
export PGPASSWORD=$POSTGRES_PASSWORD;
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
  BEGIN;
    CREATE TABLE DNA_SAMPLES (
  id_dna serial,
  dna varchar(1000) NOT NULL,
  ismutant bool NOT NULL,
  PRIMARY KEY ("id_dna")
);
  COMMIT;
EOSQL