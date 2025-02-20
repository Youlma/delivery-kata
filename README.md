# Delivery Kata

## Description
Ce projet est une solution pour le kata "Delivery" en utilisant une architecture hexagonale modulaire avec Spring Boot 3.2.x et Java 21. Il implémente un système de gestion des modes de livraison et des créneaux horaires réservables.

---

## Architecture

### Couches Principales
1. **Domain Layer**:
   - Contient les entités métier (`DeliveryMode`, `TimeSlot`) et les services métier (`DeliveryService`, `TimeSlotService`).
2. **Application Layer**:
   - Définit les cas d'utilisation (`GetDeliveryModesUseCase`, `ReserveTimeSlotUseCase`) et les ports (`TimeSlotRepository`, `EventPublisher`).
3. **Infrastructure Layer**:
   - Fournit les adapteurs pour les API REST, la persistance JPA, le cache Redis, et le streaming Kafka.

---

## Fonctionnalités Implémentées

### MVP
- Choix du mode de livraison (`DRIVE`, `DELIVERY`, `DELIVERY_TODAY`, `DELIVERY_ASAP`).
- Choix du jour et du créneau horaire selon le mode de livraison.
- Réservation de créneaux horaires disponibles.

### Features Bonus
- **API REST**: Endpoints pour interagir avec les services.
- **Sécurisation via JWT**: Authentification des clients.
- **Persistence avec JPA**: Stockage des données dans une base H2.
- **Cache Redis**: Optimisation des performances avec un cache.
- **Streaming avec Kafka**: Production et consommation d'événements métier.

---

## Installation

1. **Prérequis**
   - JDK 21
   - Maven
   - Docker (pour Kafka et Redis)

2. **Clonage du Repository**
   ```bash
   git clone <repository-url>
   cd delivery-kata
   
## Monitoring

Ce projet utilise Micrometer pour exporter des métriques vers Prometheus. Les métriques sont accessibles via l'endpoint suivant :

- URL : `http://localhost:8080/actuator/prometheus`

Vous pouvez intégrer ces métriques dans un tableau de bord Grafana pour surveiller les performances de l'application.

## Performances

Pour optimiser les performances, un cache Redis est utilisé pour stocker temporairement les créneaux horaires disponibles. Le cache est automatiquement invalidé après chaque réservation.

- Configuration Redis : `application.yml`
- Annotations utilisées : `@Cacheable`, `@CacheEvict`

## Traçabilité

Ce projet utilise Spring Cloud Sleuth et Zipkin pour fournir une traçabilité complète des requêtes. Les traces sont accessibles via l'interface web de Zipkin :

- URL : `http://localhost:9411`
- Configuration Sleuth : `application.yml`

## Logs

Les logs sont gérés avec Logback et configurés pour être affichés dans la console ainsi que sauvegardés dans des fichiers journalisés avec rotation quotidienne.

- Fichier de configuration : `logback-spring.xml`
- Emplacement des logs : `logs/delivery-app.log`

## Gestion des Transactions

Ce projet utilise JPA pour gérer les transactions. Toutes les opérations critiques sont encapsulées dans des transactions pour garantir l'intégrité des données.

- Annotation utilisée : `@Transactional`
- Configuration : `TimeSlotService`


## Migration vers PostgreSQL

La base de données H2 est utilisée pour le développement, tandis que PostgreSQL est utilisée pour la production. La configuration PostgreSQL est définie dans `application.yml`.

- URL de connexion : `jdbc:postgresql://localhost:5432/delivery`
- Script d'initialisation : `schema.sql`


