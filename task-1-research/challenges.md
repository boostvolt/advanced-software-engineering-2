# Task 1.2 - Main Challenges

## The core challenge: local fluency versus system-level reliability

The most important tension in AI-assisted SWE is that generative models are often fluent at the local level but unreliable at the system level. They can produce a function, test, explanation, or refactoring suggestion quickly, but they do not automatically understand why the broader system is designed the way it is. In large software systems, this distinction is critical. A change can be locally elegant and still be globally wrong because it violates an architectural boundary, misses a side effect, ignores a runtime assumption, or introduces an unseen dependency. This is one reason why research and industry reporting repeatedly emphasize human oversight rather than full automation [5], [6], [11].

## Correctness and hallucination

A recurring challenge in the literature is the mismatch between how convincing an answer sounds and how correct it actually is. The Stack Overflow study by Kabir et al. is especially relevant here. It found that 52% of ChatGPT answers to programming questions contained incorrect information and that 77% were verbose, yet users still preferred many answers because they were well articulated [2]. In software engineering this is dangerous because the output is not merely text. It can become code, tests, or design decisions. Once the tool is integrated into a developer workflow, the cost of over-trust can be real: latent defects, insecure implementations, shallow tests, or wrongly justified changes.

This challenge becomes harder in large systems because many errors are not obvious. A generated function may compile. A generated test may pass. A refactoring may seem to improve readability. None of these is sufficient. The question is whether the output is faithful to business logic, system boundaries, runtime behavior, and maintainability constraints. AI assistance therefore increases the need for deliberate validation rather than reducing it.

## Context-window and repository understanding limits

Another central challenge is context. Large systems are not only large in file count. They are large in semantics. Meaning is distributed across code, configuration, documentation, tickets, naming conventions, and team memory. Even when modern tools can access large context windows, they still do not automatically reconstruct the hidden intent behind the system. Real-world evidence from Cisco’s study of Copilot points in this direction: the tool saved time on documentation, repetitive coding, and test generation, but struggled more with complex tasks, large functions, multiple files, and proprietary contexts [11].

This matters because many high-value engineering tasks are inherently brownfield rather than greenfield. The developer is not creating a clean new function from scratch. The developer is changing an existing system with history. In such settings, repository context and domain specificity matter more than raw generation capability. This is one reason why repository-integrated tools are often more useful than generic chat systems, but also why even integrated tools have clear limits.

## Security, privacy, and data leakage

AI-assisted SWE introduces a governance problem in addition to a technical one. Many tools operate on external infrastructure, and careless prompt usage can move sensitive code or business information outside the trusted boundary of the organization. The Samsung incident is the most widely cited industrial warning case. After employees uploaded sensitive code to ChatGPT, Samsung restricted the use of generative AI tools on company-owned devices and internal networks [10]. Whether one interprets the incident primarily as a policy failure, training failure, or tooling failure, the underlying point is the same: AI assistance changes the data exposure surface.

This challenge is especially serious in large systems because the most valuable AI use cases often involve proprietary logic, incident data, architecture documentation, or internal APIs. The better the prompt, the more likely it is to contain sensitive context. That creates a difficult trade-off between usefulness and exposure. Organizations therefore need approved tools, usage policies, model-selection rules, and clear boundaries for what data may be shared.

## Measurement and false confidence in productivity claims

Another challenge is evaluation. AI tools often produce immediately visible output, which makes them feel productive. However, software engineering value is not only measured in generated lines or speed of first draft. It is measured in throughput, integration time, review quality, defect rates, maintainability, and delivery outcomes. GitHub’s enterprise study with Accenture is useful because it combines perception data and telemetry, showing improvements in adoption, satisfaction, pull requests, and successful builds [3]. At the same time, the open-source study by Song et al. found a different nuance: Copilot increased project-level productivity by 6.5% but also increased integration time by 41.6%, suggesting that coordination costs can rise even when contribution output improves [12].

This is highly relevant in ASE because large systems are coordination systems. A tool that helps one developer produce code faster may still create more work during integration, review, or maintenance. That does not mean the tool has no value. It means productivity must be analyzed at the right level.

## Skills, mentoring, and team redesign

AI-assisted SWE also raises a learning problem. Developers do not only produce code; they also learn systems, internalize patterns, and exchange tacit knowledge through review and collaboration. Deloitte notes that AI-first development teams are likely to change team composition, potentially with fewer entry-level developers, more specialized roles, and more emphasis on supervision and orchestration [9]. The same outlook also notes concerns that AI tools may reduce mentoring and collaboration opportunities when they replace interaction with colleagues [9].

This is especially important in large systems, where onboarding is already difficult. If junior developers rely heavily on AI to navigate the codebase, they may move faster on immediate tasks while learning less of the deeper architecture. Conversely, AI may also help experienced developers transfer knowledge more efficiently if used well. The technology therefore creates both a risk and an opportunity. The critical point is that engineering teams must decide deliberately what kind of learning culture they want to preserve.

## From assistance to agency

Finally, a major emerging challenge is the move from assistant-style tools to agentic workflows. Gartner argues that AI agents will smooth friction across the SDLC and disrupt traditional software engineering roles, but also warns that they introduce new security risks, vulnerabilities, and role changes [6]. The challenge here is escalation. A flawed code suggestion is one thing. A flawed multi-step autonomous workflow that edits files, runs tools, and proposes changes across the codebase is a different category of risk. The more authority is delegated to the system, the higher the need for bounded scopes, approvals, auditing, and clear rollback paths.

## Interim conclusion

The literature does not support the simplistic claim that AI-assisted SWE is either a revolution with no downside or a fad with no value. The more accurate conclusion is that it amplifies both capability and responsibility. It can compress low-level effort, but it also makes correctness checking, context management, governance, and skill development more important. That is exactly why it is a serious challenge in large complex software systems.
