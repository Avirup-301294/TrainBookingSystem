# Train Ticket Booking System API

## Entities

### Ticket
- id `<Long>`
- user `<User>`
- train `<Train>`
- from `<String>`
- to `<String>`
- pricePaid `<Double>`

### TicketUpdateRequest
- ticket_id `<Long>`
- modifiedSeatNumber `<String>`

### Train
- id `<Long>`
- section `<String>`
- seatNumber `<String>`

### User
- id `<Long>`
- firstName `<String>`
- lastName `<String>`
- email `<String>`

### UserTrainInfo
- ticketId `<Long>`
- userId `<Long>`
- firstName `<String>`
- lastName `<String>`
- email `<String>`
- trainId `<Long>`
- section `<String>`
- seatNumber `<String>`


```agsl
+--------------+             +--------------+            +--------------+
|    Ticket    |             |     User     |            |    Train     |
+--------------+             +--------------+            +--------------+
| id: Long     |             | id: Long     |            | id: Long     |
| user: User   | <---------> | firstName:   |            | section:     |
| train: Train |             | String       |            | String       |
| from: String |             | lastName:    |            | seatNumber:  |
| to: String   |             | String       |            | String       |
| pricePaid:   |             | email:       |            |              |
| Double       |             | String       |            |              |
+--------------+             +--------------+            +--------------+
```



## Controller Endpoints

### User

#### CreateUser
- Endpoint: `POST /user/create`
- Description: Create a new user.
- Example cURL:
    ```bash
    curl --location 'localhost:8080/user/create' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "firstName":"abc",
    "lastName":"xyz",
    "email": "email@example.com"
    }'
    ```

#### GetAllUser
- Endpoint: `GET /user/all`
- Description: Retrieve all users.
- Example cURL:
    ```bash
    curl --location 'localhost:8080/user/all'
    ```

#### UpdateUser
- Endpoint: `PUT /user/update`
- Description: Update an existing user.
- Example cURL:
    ```bash
    curl --location --request PUT 'localhost:8080/user/update' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "id":2,
    "firstName": "Monisha",
    "lastName": "Deb",
    "email": "monishadev95@gmail.com"
    }'
    ```

#### RemoveUser
- Endpoint: `DELETE /users/remove/{id}`
- Description: Remove a user by ID.
- Example cURL:
    ```bash
    curl --location --request DELETE 'localhost:8080/users/remove/2'
    ```

### Train

#### GetTrain
- Endpoint: `GET /train`
- Description: Retrieve train information by ID.
- Example cURL:
    ```bash
    curl --location 'localhost:8080/train?id=100'
    ```

### Ticket

#### BookTicket
- Endpoint: `POST /ticket/book`
- Description: Book a new train ticket.
- Example cURL:
    ```bash
    curl --location 'localhost:8080/ticket/book' \
    --header 'Content-Type: application/json' \
    --data '{
    "user": {
    "id":2
    },
    "train": {
    "id":100
    },
    "from": "Bangalore",
    "to": "Srinagar",
    "pricePaid": 2500.00
    }'

#### GetTicketById
- Endpoint: `GET /ticket`
- Description: Retrieve ticket information by ID.
- Example cURL:
    ```bash
    curl --location 'localhost:8080/ticket?id=1000'
    ```

#### UpdateUserSeat
- Endpoint: `PUT /ticket/updateUserSeat`
- Description: Update the seat number of a ticket.
- Example cURL:
    ```bash
    curl --location --request PUT 'localhost:8080/ticket/updateUserSeat' \
    --header 'Content-Type: application/json' \
    --data '{"ticketId": 1000, "modifiedSeatNumber": "A12"}'
    ```

### UserTrainInfo

#### GetUserTrainInfo
- Endpoint: `GET /userTrainInfo`
- Description: Retrieve user train information by ID.
- Example cURL:
    ```bash
    curl --location 'localhost:8080/userTrainInfo?id=2'
    ```

