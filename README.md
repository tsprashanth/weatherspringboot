# weatherspringboot

Weather Service API

A Spring Boot REST API that returns today’s short weather forecast and a temperature classification (HOT, COLD, MODERATE) based on latitude and longitude.

This service uses the public API provided by the National Weather Service as its data source.

📌 Features

Accepts latitude and longitude as query parameters

Calls NWS /points/{lat},{lon} endpoint

Retrieves forecast for today

Returns:

Short forecast (e.g., “Partly Cloudy”)

Temperature

Derived temperature category:

HOT (≥ 85°F)

MODERATE (51–84°F)

COLD (≤ 50°F)

🛠️ Technology Stack

Java 17

Spring Boot 3

Gradle

REST (Spring Web)

Jackson for JSON parsing

🚀 Getting Started
1️⃣ Prerequisites

Java 17 installed

Gradle (or use included Gradle Wrapper)

Spring Tool Suite (optional but recommended)

▶️ Running Locally
Option 1: Using Spring Tool Suite

File → Import → Existing Gradle Project

Select the project root

Right-click project → Run As → Spring Boot App

The server will start on:

http://localhost:8080
Option 2: Using Terminal

From project root:

./gradlew bootRun
🧪 Testing the API

Example request:

GET http://localhost:8080/api/weather?lat=33.7490&lon=-84.3880

Example response:

{
  "shortForecast": "Partly Cloudy",
  "temperature": 72,
  "temperatureCategory": "MODERATE"
}
📦 Building for Deployment

To build a deployable JAR:

./gradlew clean build

The JAR will be generated at:

build/libs/weather-service-0.0.1-SNAPSHOT.jar

To run on a server:

java -jar build/libs/weather-service-0.0.1-SNAPSHOT.jar
🏗️ API Design
Endpoint
GET /api/weather
Query Parameters
Parameter	Type	Required	Description
lat	double	Yes	Latitude coordinate
lon	double	Yes	Longitude coordinate
