# 🤺 FencePro Backend

Backend Spring Boot para la aplicación FencePro - Sistema de gestión de clubes de esgrima, competiciones y entrenamientos.

---

## 🚀 Configuración Rápida

### 1️⃣ Clonar el repositorio
```bash
git clone <tu-repo>
cd backend
```

### 2️⃣ Configurar variables de entorno

#### Opción A: Desarrollo Local (MySQL local)
```bash
# No necesitas hacer nada, usa valores por defecto
# O crea .env.local si quieres personalizar
cp .env.example .env.local
```

#### Opción B: AWS RDS (Producción)
```bash
# Copia la plantilla
cp .env.example .env.aws

# Edita con tus credenciales reales
nano .env.aws

# Configura:
# - DB_URL (tu endpoint RDS)
# - DB_USERNAME (admin)
# - DB_PASSWORD (tu password)
# - JWT_SECRET (genera uno aleatorio)
```

### 3️⃣ Compilar el proyecto
```bash
mvn clean package -DskipTests
```

### 4️⃣ Ejecutar

#### Desarrollo Local:
```bash
java -jar target/fencepro-backend-0.0.1-SNAPSHOT.jar
```

#### AWS RDS:
```bash
# Cargar variables de entorno y ejecutar
export $(cat .env.aws | xargs) && java -jar target/fencepro-backend-0.0.1-SNAPSHOT.jar
```

---

## 📁 Estructura del Proyecto

```
backend/
├── src/main/
│   ├── java/com/fencepro/
│   │   ├── config/          # Configuración (Security, CORS, etc)
│   │   ├── controller/      # REST Controllers
│   │   ├── model/           # Entidades JPA
│   │   ├── repository/      # Repositorios Spring Data
│   │   ├── service/         # Lógica de negocio
│   │   └── dto/             # Data Transfer Objects
│   └── resources/
│       ├── application.properties  # Configuración principal
│       └── data.sql                # Datos iniciales
├── .env.example             # Plantilla de variables (PÚBLICA)
├── .env.aws                 # Variables AWS (NO SUBIR A GIT)
├── pom.xml                  # Dependencias Maven
└── README.md                # Este archivo
```

---

## 🔐 Seguridad

### Variables de Entorno
- **`.env.example`**: Plantilla pública (SÍ se sube a GitHub)
- **`.env.local`**: Desarrollo local (NO se sube a GitHub)
- **`.env.aws`**: Producción AWS (NO se sube a GitHub)

### JWT
- Genera un secret aleatorio de mínimo 32 caracteres
- Ejemplo: `openssl rand -base64 32`

---

## 🗄️ Base de Datos

### MySQL Local (Docker)
```bash
docker run -d \
  --name mysql-fencepro \
  -p 3307:3306 \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=fencepro \
  mysql:8.0
```

### AWS RDS
- Motor: MySQL 8.0
- Instancia: db.t3.micro (Free Tier)
- Puerto: 3306
- Security Group: Permitir puerto 3306 desde tu IP

---

## 📡 API Endpoints

### Autenticación
- `POST /api/auth/login` - Login
- `POST /api/auth/register` - Registro

### Usuarios
- `GET /api/users` - Listar usuarios
- `GET /api/users/{id}` - Usuario por ID
- `PUT /api/users/{id}` - Actualizar usuario
- `DELETE /api/users/{id}` - Eliminar usuario

### Clubes de Esgrima
- `GET /api/clubs` - Listar clubes
- `POST /api/clubs` - Crear club
- `GET /api/clubs/{id}` - Club por ID
- `PUT /api/clubs/{id}` - Actualizar club

### Competiciones
- `GET /api/competitions` - Listar competiciones
- `POST /api/competitions` - Crear competición
- `GET /api/competitions/{id}` - Competición por ID

### Entrenamientos
- `GET /api/trainings` - Listar entrenamientos
- `POST /api/trainings` - Crear entrenamiento

---

## 📚 Documentación API

Swagger UI disponible en:
```
http://localhost:8080/swagger-ui.html
```

OpenAPI JSON:
```
http://localhost:8080/api-docs
```

---

## 🧪 Testing

```bash
# Ejecutar todos los tests
mvn test

# Ejecutar con cobertura
mvn test jacoco:report
```

---

## 🐛 Troubleshooting

### Error: "Access denied for user"
- Verifica las credenciales en `.env.aws`
- Comprueba que el Security Group de RDS permite tu IP

### Error: "Communications link failure"
- Verifica el endpoint de RDS
- Comprueba conectividad: `telnet <endpoint> 3306`

### Error: "JWT signature does not match"
- Regenera el JWT_SECRET
- Asegúrate de usar el mismo secret en todos los entornos

---

## 📦 Dependencias Principales

- **Spring Boot 3.2.x**
- **Spring Security + JWT**
- **Spring Data JPA**
- **MySQL Connector**
- **Lombok**
- **Springdoc OpenAPI (Swagger)**

---

## 👥 Equipo

Proyecto desarrollado como TFC - FencePro (Gestión de Clubes de Esgrima)

---

## 📄 Licencia

Este proyecto es privado y confidencial.
