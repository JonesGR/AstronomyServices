#!/bin/bash

set -e

echo "==>Starting mvn clean package..."
mvn clean package -DskipTests

echo "==> Building Docker image astronomy-celestial-body..."
docker build -t astronomy-celestial-body .

echo "==> Ready! astronomy-celestial-body built successfully."