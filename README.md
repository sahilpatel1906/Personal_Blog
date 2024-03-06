# Group 5 - Blog Chatroom 

## Summary
The idea behind our project is to create a forum-style platform that allows users to post blogs within a feed in the form of written words with the option to add media and/or images.

The chatroom element comes into play when adding the comments feature to posts where users can interact with each other regarding various topics of interest or themes.

Users can post to their blog and also view posts from other creators.

Users can also like each other’s posts; each post can be liked once and the likes increment as more people like it.

One relevant example of a platform that has developed a similar concept is Substack.

## Functionality

<li> One-to-many relationship between User and Blog.

<li> One-to-many relationship between Blog and Posts.

<li> One-to-many relationship between Posts and Comments.

<li> Many-to-many relationship between User and Post with the likes of a post joining them together.

## MVP
<li>Creation of a new user
<li>Update the information of a user
<li>Delete a user
<li>Add a blog (Choose the name of blog eg: cooking, fitness)
<li>Add a post to a specific blog
<li>Post different content types e.g. photos or videos
<li>Add a like to a post
<li>Find a post by Id

## Extensions

<li>Add a comment to a post
<li>Like counter of each post by a specific user.

## Process

Created:
1. UML diagram and Entity Relationship Diagram.
2. Relevant packages: components, models, controllers, services, repositories for User, Blog, Post, and Comment.
3. A Data loader within the components package.
4. Models: relationship annotations, creating tables, getters and setters.
5. Repositories as interfaces.
6. DTOs in the model for each entity.
7. Controllers and services simultaneously.
<li> Tested each method using postman and checked tables on Postico for validity throughout.


## Endpoint Tables
## Blogs

|   | URL         | Method  |Description                    | Request Body |
|---|-------------|--------|--------------------------------|--------------|
| INDEX | /blogs      | GET    | Returns a list of all blogs   |              |
| CREATE| /blogs      | POST   | Creates a new blog            | {"name" : "Adam", "dateOfCreation" : "12/12/2001, "timeOfCreation" : "12:00", "userId" : 3}             |
| SHOW  | /blogs/:id  | GET    | Returns details of one specific blog |              |
| UPDATE| /blogs/:id  | PUT    | Updates a specific blog       | {"name" : "BLOG", "dateOfCreation" : "12/12/2024, "timeOfCreation" : "Tomorrow"}             |
| DELETE| /blogs/:id  | DELETE | Deletes a specific blog       |              |

---

## Posts
|   | URL         | Method | Description                    | Request Body |
|---|-------------|--------|--------------------------------|--------------|
| INDEX | /posts      | GET    | Returns a list of all posts   |              |
| CREATE| /posts      | POST   | Creates a new post            | {"title" : "Dice Post", "dateOfCreation" : "13/02/2024", "content" : "my fitness blog", "mediaURL" : "image1", "blogId" : 1}             |
| SHOW  | /posts/:id  | GET    | Returns details of one specific post |              |
| UPDATE| /posts/:id  | PUT    | Updates a specific post       | {"title" : "New Dice", "content" : "Different coloured dice", "mediaURL" : "image2"}             |
| DELETE| /posts/:id  | DELETE | Deletes a specific post       |              |
| UPDATE| /posts/:id  | PATCH | Adds and removes likes       |              |

---

## Users
|   | URL         | Method | Description                    | Request Body |
|---|-------------|--------|--------------------------------|--------------|
| INDEX | /users      | GET    | Returns a list of all users   |              |
| CREATE| /users      | POST   | Creates a new user            | {"name" : "Mike", "password" : "hello123"}             |
| SHOW  | /users/:id  | GET    | Returns details of one specific user |              |
| UPDATE| /users/:id  | PUT    | Updates a specific user       | {"name" : "Miky", "password" : "hello123"}              |
| DELETE| /blogs/:id  | DELETE | Deletes a specific user       |              |

---
## Comments
|   | URL         | Method | Description                    | Request Body |
|---|-------------|--------|--------------------------------|--------------|
| INDEX | /comments      | GET    | Returns a list of all comments   |              |
| CREATE| /comments      | POST   | Creates a new comment            | {"text" : "I hated this!", "postId" : 1, "userId" : 1}             |
| SHOW  | /comments/:id  | GET    | Returns details of one specific comment |              |
| UPDATE| /comments/:id  | PUT    | Updates a specific comment       | {"text" : "I loved this!", "postId" : 1, "userId" : 1}             |             |
| DELETE| /comments/:id  | DELETE | Deletes a specific comment       |              |
