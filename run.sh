#!/bin/bash
cd /app/SMGR1
mvn install
java -jar target/SMGR1-1.0-SNAPSHOT.jar
cd /app/pythonProject
pip3 install -r requirements.txt
python3 Constraints.py
python3 AutoParse.py
python3 CoreTimeTest.py