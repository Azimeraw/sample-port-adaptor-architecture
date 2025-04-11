# sample-port-adaptor-architecture

The example is organized as follows:

Domain Layer (Core): Contains the business model and interfaces (ports) that define operations such as registering a user and fetching a user.

Application Service (Use Case): Implements the core business use cases by orchestrating domain logic through its ports.

Inbound Adapter (Controller): Exposes REST endpoints for user operations.

Outbound Adapter (Persistence): Implements the port interface using Spring Data JPA for interacting with the database
