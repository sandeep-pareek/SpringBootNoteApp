## SpringBootNoteApp
This is a simple spring boot 2+ app with hibernate 5+ and Java 8+tech stack. UI at: https://github.com/sandeep-pareek/Angular8NoteApp

## Sample screenshot
![NoteApp](https://img.techpowerup.org/201017/noteapp.png)

## Afer merging of Spring security and JWT token branch, below are affects:

 - Admin role is able to detete note, but not user role.
 - Admin role has all access. User role has all but to delete note.
 - /auth endpoint is exempted from security. This is used to fetch JWT token
 - swagger related urls are also exempted.
 - / is forwared to swagger home by default.
 - Swagger now has Bearer token facility to provide token along with each request.
