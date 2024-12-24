#!/bin/bash
# Verifica se está em um repositório Git
if ! git rev-parse --is-inside-work-tree &>/dev/null; then
    echo "Erro: Este diretório não é um repositório Git."
    exit 1
fi

# Função para escolher a branch
escolher_branch() {
    while true; do
        read -p "Digite o nome da branch de origem: " BRANCH

        # Verifica se a branch existe no repositório remoto
        if git ls-remote --exit-code --heads origin "$BRANCH" &>/dev/null; then
            echo "Branch '$BRANCH' encontrada no repositório remoto."
            break
        else
            echo "Branch '$BRANCH' não encontrada no repositório remoto. Por favor, informe outra branch."
        fi
    done
}

# Chama a função para escolher a branch
escolher_branch

# Altera para a branch local correspondente, se necessário
if git rev-parse --verify "$BRANCH" &>/dev/null; then
    echo "Alternando para a branch local '$BRANCH'..."
    git checkout "$BRANCH"
else
    echo "Criando e alternando para a branch local '$BRANCH'..."
    git checkout -b "$BRANCH"
fi

# Atualiza a branch com as alterações do repositório remoto
echo "Fazendo pull das alterações da branch '$BRANCH'..."
if git pull origin "$BRANCH"; then
    echo "Alterações baixadas e integradas com sucesso."
else
    echo "Erro ao baixar ou integrar as alterações. Verifique possíveis conflitos."
    exit 1
fi
