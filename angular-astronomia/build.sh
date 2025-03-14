echo "Building ng app..."

npm install
npm run build

docker build -t astronomy-ng .

echo "Building ng app finished!"