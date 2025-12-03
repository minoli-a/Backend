# Product Maintenance - BackEnd (Spring Boot)

Spring Boot backend exposing REST APIs for product CRUD operations, quantity adjustments, pagination, and external product fetch.

---

## Project Structure

```
src/main/java/com/test/inventory/demo/
├── controller/  # REST endpoints
├── service/     # Business logic
├── repository/  # Database connection classes
├── exception/   # Custom exceptions
├── model/       # Entity classes
├── log/         # Log 
└── dto/         # Dto classes
```

------------------------------------------------------------

## API Endpoints

##### Paginated list of products
```
Request Type: GET
URL : /api/products?page=X
```

##### Get product by ID 
```
Request Type: GET
URL : /api/products/{id}
```

##### Create a product	
```
Request Type: POST
URL : /api/products
```

##### Update full product	
```
Request Type: PUT
URL : /api/products/{id}
```

##### Adjust quantity 	
```
Request Type: PATCH
URL : /api/products/{id}/quantity
```

##### Get third-party product
```
Request Type: GET
URL : /my-api/data
```

------------------------------------------------------------

## Exception Handling

- **Negative quantity** → `"Quantity is less than zero."`  
- **Invalid product ID** → `"Product id {id} not found"`

------------------------------------------------------------

## Logging

All logs are stored in:

```
logs/app
```

Logs include:
- API calls
- Errors
- Insert/update actions
- Quantity adjustments
- External API calls

------------------------------------------------------------

## Postman Collection

Includes:
- All endpoints
- Sample payloads
- Actual success and error responses

File: `Product Maintenance.postman_collection`

------------------------------------------------------------

## Initial SQL Data

```sql
INSERT INTO TESTDB.dbo.products (name, description, quantity)
VALUES ('Laptop', 'High-performance laptop with 16GB RAM and 512GB SSD', 50);

INSERT INTO TESTDB.dbo.products (name, description, quantity)
VALUES ('Smartphone', 'Latest smartphone with 6.5-inch display and 128GB storage', 100);

INSERT INTO TESTDB.dbo.products (name, description, quantity)
VALUES ('Wireless Mouse', 'Ergonomic wireless mouse with adjustable DPI', 200);

INSERT INTO TESTDB.dbo.products (name, description, quantity)
VALUES ('Mechanical Keyboard', 'RGB backlit mechanical keyboard with blue switches', 150);

INSERT INTO TESTDB.dbo.products (name, description, quantity)
VALUES ('USB-C Charger', 'Fast-charging USB-C power adapter for laptops and phones', 300);

INSERT INTO TESTDB.dbo.products (name, description, quantity)
VALUES ('Noise-Cancelling Headphones', 'Over-ear wireless headphones with active noise cancellation', 80);

INSERT INTO TESTDB.dbo.products (name, description, quantity)
VALUES ('Smartwatch', 'Water-resistant smartwatch with heart rate monitor and GPS', 75);

INSERT INTO TESTDB.dbo.products (name, description, quantity)
VALUES ('Bluetooth Speaker', 'Portable Bluetooth speaker with 12-hour battery life', 120);

INSERT INTO TESTDB.dbo.products (name, description, quantity)
VALUES ('External Hard Drive', '2TB USB 3.0 external hard drive for backup and storage', 60);

INSERT INTO TESTDB.dbo.products (name, description, quantity)
VALUES ('Gaming Chair', 'Ergonomic gaming chair with adjustable height and lumbar support', 40);

INSERT INTO TESTDB.dbo.products (name, description, quantity)
VALUES ('Fitness Tracker', 'Activity tracker with step counter and sleep monitoring', 90);

INSERT INTO TESTDB.dbo.products (name, description, quantity)
VALUES ('Digital Camera', 'Mirrorless digital camera with 24MP sensor and 4K video', 30);

INSERT INTO TESTDB.dbo.products (name, description, quantity)
VALUES ('LED Monitor', '27-inch Full HD LED monitor with 75Hz refresh rate', 55);

INSERT INTO TESTDB.dbo.products (name, description, quantity)
VALUES ('Wireless Earbuds', 'Noise-isolating wireless earbuds with charging case', 110);

INSERT INTO TESTDB.dbo.products (name, description, quantity)
VALUES ('Portable SSD', '500GB high-speed portable SSD for data transfer', 70);

INSERT INTO TESTDB.dbo.products (name, description, quantity)
VALUES ('Smart Home Hub', 'Voice-controlled smart home hub compatible with Alexa and Google Assistant', 25);
```
------------------------------------------------------------
