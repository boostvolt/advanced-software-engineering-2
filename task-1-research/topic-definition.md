# Topic Definition

## Title
**The Effects of AI-Assisted Software Engineering on Code Quality and Security in Real-World Projects**

## Scope
This project investigates how the mainstream adoption of AI coding assistants — GitHub Copilot, Cursor, Claude Code, ChatGPT, Windsurf, and autonomous agent frameworks — is reshaping two interdependent properties of production software:

1. **Code quality**: maintainability, duplication, churn, refactoring discipline, and the cumulative technical debt introduced by generated code that is accepted without deep review.
2. **Code security**: the rate and nature of vulnerabilities in AI-generated or AI-co-authored code, and the downstream risks created when AI output is merged at a pace faster than traditional review processes can absorb.

The unifying thread is the **shift of the bottleneck from code *production* to code *review***. AI lowers the cost of writing code to near-zero; it does not lower the cost of verifying that the code is correct, maintainable, or secure. The result is a growing gap between what is generated and what is trustworthy.

## Why this framing (and not a wider one)
"AI in software engineering" as a topic is too broad to investigate rigorously in a semester project. We deliberately narrow to two measurable outcomes (quality and security) in two observable contexts (enterprise repositories and open-source ecosystems). Both are domains where public data, academic studies, and incident reports from 2025–2026 are available, which lets us back claims with evidence rather than opinion.

## Intentionally out of scope
- Generic productivity claims ("AI makes developers X% faster") without a quality or security lens.
- The ethics of training data and copyright — a parallel topic worth a project of its own.
- Prompt engineering techniques for better generation — we look at *outcomes*, not prompting craft.
- Pure research on model architectures or fine-tuning.

## Research questions guiding the project
1. How does AI-assisted code generation affect measurable code-quality signals (churn, duplication, refactoring, technical debt) once it lands in real repositories?
2. What security vulnerability patterns are introduced or amplified by AI coding assistants, and are they the same classes of bugs human developers introduce?
3. How are code review processes and open-source maintainers adapting — or failing to adapt — to the volume of AI-generated contributions?
4. Which existing tools and methods (AI-aware linters, SAST, AI-on-AI code review, policy gates) actually close the quality/security gap in practice, and where do they still fall short?

These four questions scope Task 1 (research) and directly feed Task 2 (the case study).

## Team
- Dao Trong-Nghia (daotro01)
- Mata Marco (matamar)
- Galindo Lopez Pablo Emiliano (galinpab)
