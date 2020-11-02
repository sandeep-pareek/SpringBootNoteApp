## SpringBootNoteApp
This is a simple spring boot 2+ app with hibernate 5+ and Java 8+tech stack. UI at: https://github.com/sandeep-pareek/Angular8NoteApp

## Features:
1. `SpringBoot` 2+ with `Spring security`.
2. `JWT` based token authorization and authentication is implemented for USER and ADMIN role.
3. `Swagger2` is implemented to see APIs. `Swagger` impl is updated with auth bearer token based login.
4. Hibernate `One to One`, `One to Many` and `Many to One` association between `Note`, `Tags` using association table `note_tag`.
5. Saving `password as hash`, not plaintext.

## Sample screenshot
![NoteApp](https://img.techpowerup.org/201017/noteapp.png)

## Afer merging of Spring security and JWT token branch, below are affects:

 - Admin role is able to detete note, but not user role.
 - Admin role has all access. User role has all but to delete note.
 - /auth endpoint is exempted from security. This is used to fetch JWT token
 - swagger related urls are also exempted.
 - / is forwared to swagger home by default.
 - Swagger now has Bearer token facility to provide token along with each request.
