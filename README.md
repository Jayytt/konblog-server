# KonBlog — Full-Stack Refactor

Spring Boot 3 + Vue 3 Monorepo. Cute pink blog + WeChat green admin.

## Structure

```
KonBlog/
├── konblog-server/    Spring Boot 3.3 + SaToken + MyBatis Plus + Knife4j
│   └── 69 Java files (11 entities, 11 mappers, 9 modules, full CRUD)
├── konblog-web/       pnpm workspace Monorepo
│   ├── apps/blog/     Vue 3 + Vite + UnoCSS (cute pink)
│   ├── apps/admin/    Vue 3 + Vite + Element Plus (WeChat green)
│   └── packages/shared/  API, types, styles
└── scripts/           helper scripts
```

## Quick Start

### Backend (IDEA)
1. Open `konblog-server/pom.xml` in IntelliJ IDEA
2. Run `KonblogApplication` (port 8080)
3. API docs: http://localhost:8080/doc.html

### Frontend
```bash
cd konblog-web
npm install -g pnpm
pnpm install
pnpm dev:blog     # http://localhost:3000 (cute pink)
pnpm dev:admin    # http://localhost:3001 (WeChat green)
```

## Tech Stack

| Layer   | Tech |
|---------|------|
| Backend | Spring Boot 3.3, Java 17, MyBatis Plus 3.5, SaToken, Knife4j |
| DB      | MySQL 9.2 |
| Cache   | Redis 8.4 |
| Blog FE | Vue 3, Vite 5, UnoCSS, Pinia, Vue Router |
| Admin FE| Vue 3, Vite 5, Element Plus, Pinia, Vue Router |
| Shared  | TypeScript, axios, CSS custom properties |

## Design Themes

- **Blog** — Cute pink (`#f472b6`), Poppins + Fredoka fonts, 16px radius
- **Admin** — WeChat green (`#07C160`), dark sidebar `#2E2E2E`, 6px radius
- Both support dark mode via `[data-mode="dark"]`

## API Endpoints

| Module   | Public (user)         | Admin (SaCheckRole)        |
|----------|-----------------------|----------------------------|
| Article  | GET /article/user/*   | POST/PUT/DELETE /article/admin/* |
| Category | GET /category/user/list | POST/PUT/DELETE /category/admin/* |
| Tag      | GET /tag/user/list    | POST/PUT/DELETE /tag/admin/* |
| Link     | GET /link/user/list   | POST/PUT/DELETE /link/admin/* |
| Comment  | GET /comment/user/*   | DELETE /comment/admin/* |
| User     | —                     | POST/PUT/DELETE /user/admin/* |
| Role     | —                     | POST/PUT/DELETE /role/admin/* |
| Menu     | —                     | GET /menu/admin/tree |
| Auth     | POST /auth/login, /auth/logout | — |