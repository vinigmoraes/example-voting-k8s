deployment:
	docker build -t example-voting-app .
	sleep 2
	docker tag example-voting-app vinigmoraes/example-voting-app:latest
	sleep 2
	docker push vinigmoraes/example-voting-app:latest

run:
	./gradlew build & docker-compose up --build
