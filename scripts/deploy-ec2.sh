#!/bin/bash

set -e

echo "🚀 Iniciando deploy manual a EC2..."

# Variables (ajustar según tu configuración)
EC2_HOST="${EC2_HOST:-tu-ec2-ip}"
EC2_USER="${EC2_USER:-ubuntu}"
EC2_KEY="${EC2_KEY:-~/.ssh/fencepro-key.pem}"

echo "📋 Configuración:"
echo "   Host: $EC2_HOST"
echo "   User: $EC2_USER"
echo "   Key: $EC2_KEY"
echo ""

# Verificar que la clave existe
if [ ! -f "$EC2_KEY" ]; then
    echo "❌ Error: No se encuentra la clave SSH en $EC2_KEY"
    exit 1
fi

# Conectar y ejecutar deploy
echo "🔌 Conectando a EC2..."
ssh -i "$EC2_KEY" "$EC2_USER@$EC2_HOST" << 'ENDSSH'
  set -e
  
  echo "📂 Navegando al directorio del proyecto..."
  cd /home/ubuntu/fencepro
  
  echo "📥 Actualizando código..."
  git pull origin main
  
  echo "🛑 Deteniendo contenedores..."
  docker-compose down
  
  echo "🏗️ Construyendo imágenes..."
  docker-compose build --no-cache
  
  echo "🚀 Levantando contenedores..."
  docker-compose up -d
  
  echo "⏳ Esperando a que los servicios estén listos..."
  sleep 10
  
  echo "✅ Estado de los contenedores:"
  docker-compose ps
  
  echo "🧹 Limpiando..."
  docker system prune -f
  
  echo "✅ Deploy completado"
ENDSSH

echo ""
echo "🎉 Deploy finalizado exitosamente!"
