all:
	docker-compose -f docker-compose.yml up

docker-build:
	docker build -f Dockerfile.server -t pg2-server:latest .
	docker build -f Dockerfile.client -t pg2-client:latest .