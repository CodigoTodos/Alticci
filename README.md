# Alticci

# Installation

​Have docker installed and running. 


# Build

​Pull the Docker Image for Backend Aplication:

```
docker pull bmpalves/alticci:0.0.1
```

Pull the Docker Image for Front-End Aplication: 

```
docker pull bmpalves/alticcifrontend:0.0.1
```

To enable Backend Application run the command:
```
docker run -d -p8080:8080 --name alticci bmpalves/alticci:0.0.1
``` 

Should be possible to access the backend API from the port 8080.



To enable Front-end Application run the command:  

```
docker run -d -p5500:8080 --name alticcifrontend bmpalves/alticcifrontend:0.0.1
``` 

Should be possible to see the Front-End GUI from the following address: 

```
http://localhost:5500/
``` 

# Api Documentation

Api Documentation


## Version: 1.0


**License:** [Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0)

To Aceess swagger documentation for backend API use the following address:
```
http://localhost:8080/swagger-ui/index.html
``` 


#### GET

### /alticci/{sequenceIndex}

##### Summary:

Return the result for the given index.

##### Parameters

| Name | Located in | Description | Required | Type |
| ---- | ---------- | ----------- | -------- | ---- |
| sequenceIndex | path | sequenceIndex | Yes  | Long |

##### Responses

| Code | Description | Type |
| ---- | ----------- | ------ |
| 200 | OK | Long |
