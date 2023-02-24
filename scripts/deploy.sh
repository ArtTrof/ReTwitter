#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'


scp  -i ~/.ssh/ReTwitterKey.pem \
    target/app-0.0.1-SNAPSHOT.jar \
    ec2-user@ec2-3-69-28-216.eu-central-1.compute.amazonaws.com:/home/ec2-user/


echo 'Restart server...'

ssh -i ~/.ssh/ReTwitterKey.pem ec2-user@ec2-3-69-28-216.eu-central-1.compute.amazonaws.com << EOF
pgrep java | xargs kill -9
nohup java -jar  app-0.0.1-SNAPSHOT.jar > log.txt &
EOF

echo 'Bye'