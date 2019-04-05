# microkubes-java-example
Todo Microservice REST API in Spring Boot, on top of Microkubes.


# Building the example

To build the example, run:

```bash
docker build -t todo-service .
```

# Running the example locally

You can run the example locally.

First make sure you have Gradle installed, then build and run the example:

```bash
gradle runBoot
```

Then we need to generate a JWT to simulate the JWT we're going to receive from Microkubes.

Install `jwtgen` to generate the JWT (you can skip this if you have `jwtgen` installed already):

```bash
export JWT=`jwtgen -a RS256 \
       -p keys/key.pem \
       -c "username=john.doe@example.com" \
       -c "userId=john.doe" \
       -c "roles=user" \
       -c "organizations=keitaro.com"`
```

Then we can create a TODO item:

```bash
curl http://localhost:8080/todo \
    -H "Content-Type: application/json" \
    -H "Authorization: Bearer $JWT" \
    -d '{"title": "Todo Item", "content": "Buy groceries"}'
```
We'll get something like this:

```
{"id":"480e583f-36ae-492c-9e90-c2abb3b20091","title":"Todo Item","content":"Buy groceries","timestamp":1554478560595,"owner":"john.doe@example.com"}
```

Then we can fetch the Todo item:

```bash
curl http://localhost:8080/todo/480e583f-36ae-492c-9e90-c2abb3b20091 \
    -H "Authorization: Bearer $JWT"
```

and we'll get the same item that we've created:

```
{"id":"480e583f-36ae-492c-9e90-c2abb3b20091","title":"Todo Item","content":"Buy groceries","timestamp":1554478560595,"owner":"john.doe@example.com"}
```