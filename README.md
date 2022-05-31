docker run --name postgres-0 -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres
docker run -dit -p 3306:3306 -e MYSQL_ROOT_PASSWORD=pass --name mysql mysql:latest