#!/bin/bash

set -e

echo "==>Starting mvn clean package..."
mvn clean package -DskipTests

echo "==> Building Docker image astronomy-gateway..."
docker build -t astronomy-gateway .

echo "==> Ready! astronomy-gateway built successfully."