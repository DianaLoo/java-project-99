setup:
	./gradlew wrapper --gradle-version 8.5

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew installDist

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

check-deps:
	./gradlew dependencyUpdates -Drevision=release



.PHONY: build
