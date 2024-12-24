#!/bin/bash
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

# Chama a função para escolher a branch
escolher_branch

# Verifica se há mudanças para enviar
if git diff --quiet && git diff --cached --quiet; then
    echo "Nenhuma alteração para enviar."
    exit 0
fi

# Adiciona todos os arquivos, incluindo os não rastreados (novos)
git add .

# Verifica se o script foi adicionado corretamente
echo "Arquivos adicionados:"
git status -s

# Solicita a mensagem do commit
read -p "Digite a mensagem do commit: " MESSAGE

# Faz o commit
git commit -m "$MESSAGE"

# Faz o push para a branch informada
git push origin "$BRANCH"

echo "Alterações enviadas para a branch '$BRANCH' com sucesso."