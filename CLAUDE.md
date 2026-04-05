# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Comandos

```bash
# Compilar o projeto
mvn compile

# Executar a aplicação
mvn exec:java -Dexec.mainClass="Main"

# Compilar e executar
mvn compile exec:java -Dexec.mainClass="Main"
```

> O projeto usa Java 21 com `--enable-preview`, necessário para o `void main()` sem classe envolvente (JEP 463).

## Arquitetura

Projeto de estudo de Design Patterns em Java. Cada padrão é implementado como uma demonstração isolada e executável.

### Estrutura central

- `Main.java` — ponto de entrada (usa `void main()` sem classe, recurso preview do Java 21). Instancia cada padrão e chama `execute()`.
- `runner/DefaultPatternTesting` — interface que todos os padrões implementam. Define `getName()` e `execute()`.

### Como adicionar um novo padrão

1. Crie um pacote com o nome do padrão (ex: `strategy/`).
2. Implemente a lógica do padrão dentro do pacote.
3. Crie uma classe "entry point" do padrão que implemente `DefaultPatternTesting`.
4. Adicione uma instância dessa classe à lista em `Main.java`.

### Padrões implementados

| Padrão | Pacote | Classe de entrada |
|--------|--------|-------------------|
| Observer | `observer` | `ObserverDemo` |
