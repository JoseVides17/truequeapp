# 📦 API de Sistema de Intercambios

Esta API permite la gestión de usuarios, autenticación, ítems, solicitudes de intercambio (trades), favoritos y reviews. Está diseñada para facilitar un sistema de trueque entre usuarios autenticados.

## 🌐 Servidor

- **Base URL:** `http://localhost:8080`

---

## 📌 Endpoints Principales

### 🔐 Autenticación

#### POST `/api/auth/login`
Inicia sesión con credenciales del usuario.

- **Request:** `AuthRequest`
- **Response:** `AuthResponse` con el token JWT

---

### 👤 Usuarios

#### POST `/api/users/register`
Registra un nuevo usuario.

- **Request:** `UserCreateDTO`
- **Response:** `UserDTO`

#### GET `/api/users/{id}`
Obtiene información de un usuario por ID.

- **Response:** `UserDTO`

---

### 🧾 Items

#### GET `/api/items`
Obtiene todos los items del usuario autenticado.

- **Response:** `ItemDTO[]`

#### POST `/api/items`
Crea un nuevo item.

- **Request:** `ItemCreateDTO`
- **Response:** `ItemDTO`

#### GET `/api/items/{id}`
Obtiene un item específico por ID.

- **Response:** `ItemDTO`

#### DELETE `/api/items/{id}`
Elimina un item por ID.

- **Response:** `204 No Content`

---

### 🔁 Trades (Intercambios)

#### POST `/api/trades`
Crea una nueva solicitud de intercambio (trade).

- **Request:** `TradeRequestCreateDTO`
- **Response:** `TradeRequestDTO`

#### PUT `/api/trades/{id}/change-status`
Actualiza el estado de un intercambio.

- **Request:** `TradeStatusUpdateDTO`
- **Response:** `TradeRequestDTO`

#### GET `/api/trades/my-trades`
Obtiene todos los trades del usuario autenticado.

- **Response:** `TradeRequestDTO[]`

---

### ⭐ Favoritos

#### POST `/api/favorites/{itemId}`
Agrega un item a los favoritos del usuario.

- **Response:** `FavoriteDTO`

#### DELETE `/api/favorites/{itemId}`
Elimina un item de la lista de favoritos.

- **Response:** `204 No Content`

---

### 📝 Reviews

#### POST `/api/reviews`
Crea una nueva review para un usuario.

- **Request:** `ReviewCreateDTO`
- **Response:** `ReviewDTO`

#### GET `/api/reviews/user/{userId}`
Obtiene todas las reviews asociadas a un usuario.

- **Response:** `ReviewDTO[]`

---

## 🧩 Esquemas Comunes (DTOs)

- `UserDTO`
- `UserCreateDTO`
- `AuthRequest`
- `AuthResponse`
- `ItemDTO`
- `ItemCreateDTO`
- `TradeRequestDTO`
- `TradeRequestCreateDTO`
- `TradeStatusUpdateDTO`
- `FavoriteDTO`
- `ReviewDTO`
- `ReviewCreateDTO`

> 📌 Todos los endpoints devuelven respuestas en formato JSON. Asegúrate de enviar el token JWT en el encabezado `Authorization` cuando sea requerido.

---

## 🛠️ Tecnologías

- OpenAPI 3.0.1
- Spring Boot (supuesto backend)
- JWT para autenticación
- RESTful API design

---

## 📬 Contacto

Para dudas o sugerencias, por favor contacta al desarrollador del proyecto.

---

