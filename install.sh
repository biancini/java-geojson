#!/bin/bash

ES_DIRLIB=/usr/share/elasticsearch/lib

mvn package
mvn install
sudo cp target/java-geojson*-with-dependencies.jar $ES_DIRLIB/
