up:
	docker compose up -d

clean:
	docker compose stop
	docker compose down

lint:
	./gradlew detektMain --auto-correct

doc:
	./gradlew dokkaHtml
	rm ./build/springdoc/openapi.yaml
	./gradlew generateOpenApiDocs
