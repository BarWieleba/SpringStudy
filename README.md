docker run --name postgres-0 -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres

docker run -dit -p 3306:3306 -e MYSQL_ROOT_PASSWORD=pass --name mysql mysql:latest

docker run -dp 27017:27017 --name mongodb -v mongo-data:/data/db -e MONGODB_INITDB_ROOT_USERNAME=root -e MONGODB_INITDB_ROOT_PASSWORD=pass mongo:latest
docker exec -it mongodb mongo 