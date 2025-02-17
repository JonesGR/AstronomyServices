#!/bin/bash

set -e

echo "==>Starting mvn clean package..."
mvn clean package -DskipTests

echo "==> Building Docker image astronomy-ast-type..."
docker build -t astronomy-ast-type .

echo "==> Ready! astronomy-ast-type built successfully."