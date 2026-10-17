## Beer shop "AlkashNya"

## Overview

An application that emulates the operation of a beer retail store.

## Entities

The domain entities used in the project are listed below along with their fields and relationships.

### Beer:

Fields:   
- Type
- In stock
- Name
- Description
- Alcohol content
- Density
- Country of origin
- Price
    
### Order

Fields:
- Customer
- Status
- Quantity
- Total cost
- Canceled
- Order item list

Relationships:
- a list of beer items, added when the order is placed ("Beer" to "Order")
- a customer, added when the order is placed ("Customer" to "Order")
 
### Customer

Fields:
- First name
- Last name
- Email
- Phone number
     
### Administrator
A user who processes orders and adds, modifies, and removes beer items.

Fields:
- First name
- Last name
- Email
- Phone number
        
## User Stories

### BS-1 As a "Customer", I want to receive the list of all items available in the store with a short description, and as a result I receive it

Request: `GET /api/beers`

Response: `200 OK`

```
[
    {
        "id": 1,
        "type": "light",
        "inStock": true,
        "name": "Lidskoye",
        "description": "The best beer by grandmother's recipes",
        "alcohol": 5.0,
        "density": 11.5,
        "country": "Republic of Belarus",
        "price": 5.00
    },
    {
        "id": 2,
        "type": "dark",
        "inStock": true,
        "name": "Alivaria",
        "description": "The No. 1 beer in Belarus",
        "alcohol": 4.6,
        "density": 10.2,
        "country": "Republic of Belarus",
        "price": 3.00
    }
]
```

### BS-2 As a "Customer", I want to receive the list of items filtered by the criterion "Type" (dark), and as a result I receive the list of dark-beer items

Request: `GET /api/beers?type=${beerType}`

Where: `beerType="dark"`

Response: `200 OK`

``` 
[
    {
        "id": 2,
        "type": "dark",
        "inStock": true,
        "name": "Alivaria",
        "description": "The No. 1 beer in Belarus",
        "alcohol": 4.6,
        "density": 10.2,
        "country": "Republic of Belarus",
        "price": 3.00
    }
]
```

### BS-3 As a "Customer", I want to register, and if no user with that email exists, I register

Request: `POST /api/users/sign-up`
    
```    
{
    "firstName": "Ivan",
    "secondName": "Ivanov",
    "email": "ivan.ivanov@mail.ru",
    "password": "123456",
    "phone": "+375331234567"
}
```
Response: `201 CREATED`

```
1
```

### BS-4 As a "Customer", being a registered user, I want to sign in, and if such a user exists and the password matches, I sign in

Request: `POST /api/sign-in`
    
```    
{
    "email": "ivan.ivanov@mail.ru",
    "password": "123456"
}
```
Response: `200 OK`

```
{
    token: "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGV4LmFsZXhlZXZvdkB5YW5kZXgucnUiLCJleHAiOjE1ODI2ODA3MjgsImlhdCI6MTU4MjY0NDcyOH0.oxNyf3jOPRoTuywoe2-oibyVxcisvOaPTWCaX56v9-0"
}
```

### BS-5 As a "Customer", I want to choose the beer items I'm interested in, specifying the volume, and place an order, and if I am authorized, my order is placed

Request: 

`POST /api/orders`

Headers: `Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGV4LmFsZXhlZXZvdkB5YW5kZXgucnUiLCJleHAiOjE1ODI2ODA3MjgsImlhdCI6MTU4MjY0NDcyOH0.oxNyf3jOPRoTuywoe2-oibyVxcisvOaPTWCaX56v9-0`

```
{
    "customerId": 2,
    "goods": [
        {
            "id": 2,
            "amount": 1
        },
        {
            "id": 3,
            "amount": 3
        }
    ]
}
```

Response: `201 CREATED`

```
{
    "id": 2,
    "customer": {
        "id": 2,
        "firstName": "Petr",
        "secondName": "Petrov",
        "email": "petr.petrov@yandex.ru",
        "phone": "+375337654321"
    },
    "processed": false,
    "total": 27.0,
    "canceled": false,
    "customerOrder": [
        {
            "beer": {
                "id": 2,
                "type": "dark",
                "inStock": true,
                "name": "Alivaria",
                "description": "The No. 1 beer in Belarus",
                "alcohol": 4.6,
                "density": 10.2,
                "country": "Republic of Belarus",
                "price": 3.00
            },
            "amount": 1
        },
        {
            "beer": {
                "id": 3,
                "type": "pale lager",
                "inStock": true,
                "name": "Pilsner Urquell",
                "description": "unpasteurized",
                "alcohol": 4.2,
                "density": 12.0,
                "country": "Czechia",
                "price": 8.00
            },
            "amount": 3
        }
    ]
}
```

### BS-6 As an "Administrator", I want to add a new beer item, and if it does not already exist, I add it

Request: `POST /api/beers`

Headers: `Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGV4LmFsZXhlZXZvdkB5YW5kZXgucnUiLCJleHAiOjE1ODI3NDEyMTAsImlhdCI6MTU4MjcwNTIxMH0.yfCxFB_f7U7-YTF6npRWAgZK5O_M1alWbq63gq2diuk`    

```
{
    "type": "pale lager",
    "inStock": true,
    "name": "Pilsner Urquell",
    "description": "unpasteurized",
    "alcohol": 4.2,
    "density": 12.0,
    "country": "Czechia",
    "price": 8.00
}
```

Response: `201 CREATED`

```
3
```

### BS-7 As an "Administrator", I want to change the price of a beer, and if such an item exists, I update its price

Request: `PUT /api/beers/${beerId}`

Where: `beerId=3`

Headers: `Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGV4LmFsZXhlZXZvdkB5YW5kZXgucnUiLCJleHAiOjE1ODI3NDEyMTAsImlhdCI6MTU4MjcwNTIxMH0.yfCxFB_f7U7-YTF6npRWAgZK5O_M1alWbq63gq2diuk`
    
```    
{
    "id": 3,
    "type": "pale lager",
    "inStock": true,
    "name": "Pilsner Urquell Extra",
    "description": "unpasteurized",
    "alcohol": 4.5,
    "density": 12.2,
    "country": "Czechia",
    "price": 8.30
}
```

Response: `200 OK`

```
{
    "id": 3,
    "type": "pale lager",
    "inStock": false,
    "name": "Pilsner Urquell Extra",
    "description": "unpasteurized",
    "alcohol": 4.5,
    "density": 12.2,
    "country": "Czechia",
    "price": 8.30
}
```

### BS-8 As an "Administrator", I want to delete a beer item, and if it exists, I delete it

Request: `DELETE /api/beers/${beerId}`

Where: `beerId=3`

Headers: `Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGV4LmFsZXhlZXZvdkB5YW5kZXgucnUiLCJleHAiOjE1ODI3NDEyMTAsImlhdCI6MTU4MjcwNTIxMH0.yfCxFB_f7U7-YTF6npRWAgZK5O_M1alWbq63gq2diuk`

Response: `200 OK`

### BS-9 As an "Administrator", I want to receive the list of orders, and I receive the list with information about each order

Request: `GET /api/orders`

Headers: `Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGV4LmFsZXhlZXZvdkB5YW5kZXgucnUiLCJleHAiOjE1ODI3NDEyMTAsImlhdCI6MTU4MjcwNTIxMH0.yfCxFB_f7U7-YTF6npRWAgZK5O_M1alWbq63gq2diuk`

Response: `200 OK`

```   
[
    {
        "id": 1,
        "customer": {
            "id": 1,
            "firstName": "Ivan",
            "secondName": "Ivanov",
            "email": "ivan.ivanov@mail.ru",
            "phone": "+375331234567"
        },
        "processed": true,
        "total": 31.0,
        "canceled": false,
        "customerOrder": [
            {
                "beer": {
                    "id": 2,
                    "type": "dark",
                    "inStock": true,
                    "name": "Alivaria",
                    "description": "The No. 1 beer in Belarus",
                    "alcohol": 4.6,
                    "density": 10.2,
                    "country": "Republic of Belarus",
                    "price": 3.00
                },
                "amount": 5
            },
            {
                "beer": {
                    "id": 3,
                    "type": "pale lager",
                    "inStock": true,
                    "name": "Pilsner Urquell",
                    "description": "unpasteurized",
                    "alcohol": 4.2,
                    "density": 12.0,
                    "country": "Czechia",
                    "price": 8.00
                },
                "amount": 2
            }
        ]
    },
    {
        "id": 2,
        "customer": {
            "id": 2,
            "firstName": "Petr",
            "secondName": "Petrov",
            "email": "petr.petrov@yandex.ru",
            "phone": "+375337654321"
        },
        "processed": false,
        "total": 27.0,
        "canceled": false,
        "customerOrder": [
            {
                "beer": {
                    "id": 2,
                    "type": "dark",
                    "inStock": true,
                    "name": "Alivaria",
                    "description": "The No. 1 beer in Belarus",
                    "alcohol": 4.6,
                    "density": 10.2,
                    "country": "Republic of Belarus",
                    "price": 3.00
                },
                "amount": 1
            },
            {
                "beer": {
                    "id": 3,
                    "type": "pale lager",
                    "inStock": true,
                    "name": "Pilsner Urquell",
                    "description": "unpasteurized",
                    "alcohol": 4.2,
                    "density": 12.0,
                    "country": "Czechia",
                    "price": 8.00
                },
                "amount": 3
            }
        ]
    }
] 
```

### BS-10 As an "Administrator", I want to change an order's status to "Processed", and I update it

Request: `PATCH /api/orders/${orderId}?status=${status}`

Where: `orderId=2, status=true`

Headers: `Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGV4LmFsZXhlZXZvdkB5YW5kZXgucnUiLCJleHAiOjE1ODI3NDEyMTAsImlhdCI6MTU4MjcwNTIxMH0.yfCxFB_f7U7-YTF6npRWAgZK5O_M1alWbq63gq2diuk`
    
Response: `200 OK`

```
2
```

### BS-11 As an "Administrator", I want to delete an order, and if the order is processed, I delete it

Request: `DELETE /api/orders/${orderId}`

Where: `orderId=2`
 
Headers: `Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGV4LmFsZXhlZXZvdkB5YW5kZXgucnUiLCJleHAiOjE1ODI3NDEyMTAsImlhdCI6MTU4MjcwNTIxMH0.yfCxFB_f7U7-YTF6npRWAgZK5O_M1alWbq63gq2diuk`
    
Response: `200 OK`

### BS-12 As an "Administrator", I want to delete a "User", and if the user has no open orders, I delete it

Request: `DELETE /api/users/${userId}`

Where: `userId=2`

Headers: `Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGV4LmFsZXhlZXZvdkB5YW5kZXgucnUiLCJleHAiOjE1ODI3NDEyMTAsImlhdCI6MTU4MjcwNTIxMH0.yfCxFB_f7U7-YTF6npRWAgZK5O_M1alWbq63gq2diuk`
    
Response: `200 OK`

### BS-13 As a "Customer", I want to cancel an order, and if the order's status is not processed, I cancel it

Request: `PATCH /api/orders/${orderId}?canceled=${status}`

Where: `orderId=2, status=true`

Headers: `Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGV4LmFsZXhlZXZvdkB5YW5kZXgucnUiLCJleHAiOjE1ODI2ODA3MjgsImlhdCI6MTU4MjY0NDcyOH0.oxNyf3jOPRoTuywoe2-oibyVxcisvOaPTWCaX56v9-0`
    
Response: `200 OK`