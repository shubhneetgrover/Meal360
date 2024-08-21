
# Meal 360

Meal360 is a microservice-based backend server for a meal ordering system, developed using Java Spring Boot. The architecture is designed to handle various aspects of a food delivery platform, including user authentication, restaurant management, menu creation, promotions, and order processing.


## Features

- **Authentication Service**: Manages user login and registration using JWT and OAuth.
- **Admin Service**: Handles restaurant and menu management.
- **Menu Service**: Manages the creation and update of restaurant menus.
- **Order Service**: Processes orders and tracks their status.
- **Coupon Service**: Manages promotional coupons and discounts.

## Project APIs

- **/config**: Centralized configuration for the microservices.
- **/authenticate**: Manages user authentication and authorization.
- **/admin**: Contains controllers and services for managing restaurants and menus.
- **/coupons**: Handles the creation and validation of discount coupons.
- **/menu**: Manages menu-related operations, including item additions and updates.
- **/orders**: Processes customer orders and manages their lifecycle.
- **/safety**: Ensures compliance with health and safety regulations.

## Getting Started

### Prerequisites
- Java 11+
- Maven
### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/shubhneetgrover/Meal360.git
   ```
2. Navigate to the project directory:
   ```bash
   cd Meal360
   ```
3. Build the project using Maven:
    ```bash
   mvn clean install
    ```
### Running the Services
To run the services, execute the following command from the root directory:
```bash
mvn spring-boot:run
```
Each service can also be started individually by navigating to its directory and running the command above.

## Contributing

Contributions are welcome! Please fork this repository and submit a pull request for review.

## License
This project is licensed under the MIT License.

## Contact
For any inquiries or issues, please contact [Shubhneet Grover](https://github.com/shubhneetgrover).



