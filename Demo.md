### Get the list of available beer items

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
    },
    {
        "id": 3,
        "type": "pale lager",
        "inStock": true,
        "name": "Pilsner Urquell",
        "description": "unpasteurized",
        "alcohol": 4.2,
        "density": 12.0,
        "country": "Czechia",
        "price": 8.00
    }
]
```

### Get the list of available beer items filtered by type dark

Request: `GET /api/beers?type=dark`

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

### Sign in as administrator

Request: `POST /api/sign-in`
    
```    
{
    "email": "alex.alexeev@gmail.com",
    "password": "password"
}
```
Response: `200 OK`
```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnRvbi5hbnRvbm92QG1haWwucnUiLCJleHAiOjE1ODI4MjU2ODgsImlhdCI6MTU4Mjc4OTY4OH0.oz7rblKyHA0jCHaA0BjjguMldkK8z0nfHBg8cWB2K28"
}
```

### As an administrator, add a new beer item

Request: `POST /api/beers`

Headers: `Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnRvbi5hbnRvbm92QG1haWwucnUiLCJleHAiOjE1ODI4MjU2ODgsImlhdCI6MTU4Mjc4OTY4OH0.oz7rblKyHA0jCHaA0BjjguMldkK8z0nfHBg8cWB2K28`
    
```    
{
    "type": "light",
    "inStock": true,
    "name": "Krynitsa Pilsner",
    "description": "A mellow beer with a clean, harmonious taste, a sparkling golden color and a thick snow-white head. This variety will appeal to those looking for a light beer that preserves a fresh bouquet of aromatic hops and a delicate bitterness on the finish.",
    "alcohol": 4.4,
    "density": 10.5,
    "country": "Republic of Belarus",
    "price": 3.20
}
```

Response: `201 CREATED`

```
4
```

### As an administrator, update the information about the beer with id = 4, change the price

Request: `PUT /api/beers/4`

Headers: `Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnRvbi5hbnRvbm92QG1haWwucnUiLCJleHAiOjE1ODI4MjU2ODgsImlhdCI6MTU4Mjc4OTY4OH0.oz7rblKyHA0jCHaA0BjjguMldkK8z0nfHBg8cWB2K28`
    
```    
{
    "type": "light",
    "inStock": true,
    "name": "Krynitsa Pilsner",
    "description": "A mellow beer with a clean, harmonious taste, a sparkling golden color and a thick snow-white head. This variety will appeal to those looking for a light beer that preserves a fresh bouquet of aromatic hops and a delicate bitterness on the finish.",
    "alcohol": 4.4,
    "density": 10.5,
    "country": "Republic of Belarus",
    "price": 5.20
}
```

Response: `201 CREATED`

```
{
    "id": 4,
    "type": "light",
    "inStock": true,
    "name": "Krynitsa Pilsner",
    "description": "A mellow beer with a clean, harmonious taste, a sparkling golden color and a thick snow-white head. This variety will appeal to those looking for a light beer that preserves a fresh bouquet of aromatic hops and a delicate bitterness on the finish.",
    "alcohol": 4.4,
    "density": 10.5,
    "country": "Republic of Belarus",
    "price": 5.20
}
```

### As an administrator, delete the beer with id = 4

Request: `DELETE /api/beers/4`

Headers: `Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnRvbi5hbnRvbm92QG1haWwucnUiLCJleHAiOjE1ODI4MjU2ODgsImlhdCI6MTU4Mjc4OTY4OH0.oz7rblKyHA0jCHaA0BjjguMldkK8z0nfHBg8cWB2K28`

Response: `200 OK`

### Register as a customer

Request: `POST /api/users/sign-up`
    
```    
{
    "firstName": "Anton",
    "secondName": "Antonov",
    "email": "anton.antonov@mail.ru",
    "password": "anton",
    "phone": "+375331234567"
}
```
Response: `201 CREATED`

```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnRvbi5hbnRvbm92QG1haWwucnUiLCJleHAiOjE1ODI4MjU2ODgsImlhdCI6MTU4Mjc4OTY4OH0.oz7rblKyHA0jCHaA0BjjguMldkK8z0nfHBg8cWB2K28"
}
```

### Place an order as an authenticated user 

Request: `POST /api/orders`

Headers: `Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnRvbi5hbnRvbm92QG1haWwucnUiLCJleHAiOjE1ODI4MjU2ODgsImlhdCI6MTU4Mjc4OTY4OH0.oz7rblKyHA0jCHaA0BjjguMldkK8z0nfHBg8cWB2K28`

```
{
    "customerId": 4,
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
    "id": 3,
    "user": {
        "id": 4,
        "firstName": "Anton",
        "secondName": "Antonov",
        "password": null,
        "email": "anton.antonov@mail.ru",
        "phone": "+375331234567"
    },
    "processed": false,
    "canceled": false,
    "total": 27.00,
    "customerOrders": [
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
        },
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
        }
    ]
}
```

### Cancel an order as an authorized user

Request: `PATCH /api/orders/2?canceled=true`

Headers: `Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnRvbi5hbnRvbm92QG1haWwucnUiLCJleHAiOjE1ODI4MjU2ODgsImlhdCI6MTU4Mjc4OTY4OH0.oz7rblKyHA0jCHaA0BjjguMldkK8z0nfHBg8cWB2K28`

Response: `200 OK`

```
2
```

### Sign in as a registered user

Request: `POST /api/sign-in`
    
```    
{
    "email": "petr.petrov@yandex.ru",
    "password": "654321"
}
```

Response: `200 OK`

```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZXRyLnBldHJvdkB5YW5kZXgucnUiLCJleHAiOjE1ODMxMTUzNjksImlhdCI6MTU4MzA3OTM2OX0.1g_o0h5fvEobgZ5JGABbqrxA9X6Sds4bRa7CaAnOfJE"
}
```

### Place an order as an authenticated user 

Request: `POST /api/orders`

Headers: `Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZXRyLnBldHJvdkB5YW5kZXgucnUiLCJleHAiOjE1ODMxMTUzNjksImlhdCI6MTU4MzA3OTM2OX0.1g_o0h5fvEobgZ5JGABbqrxA9X6Sds4bRa7CaAnOfJE`

```
{
    "customerId": 2,
    "goods": [
        {
            "id": 1,
            "amount": 5
        },
        {
            "id": 3,
            "amount": 4
        }
    ]
}
```

Response: `201 CREATED`

```
{
    "id": 3,
    "user": {
        "id": 2,
        "firstName": "Petr",
        "secondName": "Petrov",
        "password": null,
        "email": "petr.petrov@yandex.ru",
        "phone": "+375337654321"
    },
    "processed": false,
    "canceled": false,
    "total": 57.00,
    "customerOrders": [
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
        "amount": 4
    },
    {
        "beer": {
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
        "amount": 5
        }
    ]
}
```

### As an administrator, view the list of orders

Response: `GET /api/orders`

Headers: `Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnRvbi5hbnRvbm92QG1haWwucnUiLCJleHAiOjE1ODI4MjU2ODgsImlhdCI6MTU4Mjc4OTY4OH0.oz7rblKyHA0jCHaA0BjjguMldkK8z0nfHBg8cWB2K28`

Request: `200 OK`

```
[
    {
        "id": 1,
        "user": {
            "id": 1,
            "firstName": "Ivan",
            "secondName": "Ivanov",
            "password": null,
            "email": "ivan.ivanov@mail.ru",
            "phone": "+375331234567"
        },
        "processed": true,
        "canceled": false,
        "total": 25.00,
        "customerOrders": [
            {
            "beer": {
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
            "amount": 2
            },
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
            }
        ]
    },
    {
        "id": 2,
        "user": {
            "id": 4,
            "firstName": "Anton",
            "secondName": "Antonov",
            "password": null,
            "email": "anton.antonov@mail.ru",
            "phone": "+375331234567"
        },
        "processed": false,
        "canceled": true,
        "total": 27.00,
        "customerOrders": [
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
    },
    {
        "id": 3,
        "user": {
            "id": 2,
            "firstName": "Petr",
            "secondName": "Petrov",
            "password": null,
            "email": "petr.petrov@yandex.ru",
            "phone": "+375337654321"
        },
        "processed": false,
        "canceled": false,
        "total": 57.00,
        "customerOrders": [
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
            "amount": 4
        },
        {
            "beer": {
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
            "amount": 5
            }
        ]
    }
]
```

### As an administrator, change the status of the order with id = 3

Request: `PATCH /api/orders/3?status=true`

Headers: `Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnRvbi5hbnRvbm92QG1haWwucnUiLCJleHAiOjE1ODI4MjU2ODgsImlhdCI6MTU4Mjc4OTY4OH0.oz7rblKyHA0jCHaA0BjjguMldkK8z0nfHBg8cWB2K28`

Response: `200 OK`

```
2
```
