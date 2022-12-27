# Voting management APIs 

This project includes RESTFul APIs for a simple vote mangement system.
The project developed in spring boot framework environment.


## Features

- The API entercandidate shall take a name as a parameter and save that into a table with a count(vote count) initialized to 0
- The API castvote take valid candidate name as a parameter, increment the vote count, and return it.
- The API countvote take a valid candidate name as a parameter and return the latest vote count.
- The API listvote  return all names and vote counts. The return value is in JSON.
- The API getwinner  return the name of the candidate/candidates who got the most votes.

## API Reference

#### Add Candidates
```http
  POST /enterCandidate
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `name` | `string` | **Required**. Candidate name |

#### Cast vote
```http
  POST /castvote
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `string` | **Required**. Candidate name |

#### Count vote
```http
  GET /countvote
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `String` |  |

#### List vote
```http
  GET /listvote
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|       | `JSON` |  |

####  Get winner
```http
  GET /getwinner
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|       | `String` |  |
