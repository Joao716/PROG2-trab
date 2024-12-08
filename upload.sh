#!/bin/bash

SCRIPT_NAME=$(basename "$0")

# Verifica se está em um repositório Git
if ! git rev-parse --is-inside-work-tree &>/dev/null; then
    echo "Erro: Este diretório não é um repositório Git."
    exit 1
fi

# Função para escolher a branch
escolher_branch() {
    while true; do
        read -p "Digite o nome da branch de destino: " BRANCH

        # Verifica se a branch já existe
        if git show-ref --verify --quiet refs/heads/"$BRANCH"; then
            echo "Branch '$BRANCH' encontrada. Alternando para ela..."
            git checkout "$BRANCH"
            break
        else
            # Se não existir, pergunta se deseja criar
            read -p "Branch '$BRANCH' não encontrada. Deseja criá-la? (s/n): " RESP
            if [[ "$RESP" =~ ^[Ss]$ ]]; then
                echo "Criando a branch '$BRANCH'..."
                git checkout -b "$BRANCH"
                break
            else
                echo "Por favor, informe outra branch."
            fi
        fi
    done
}
