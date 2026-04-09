# Task 2 - Selected Solution and Rationale

## Selected solution: GitHub Copilot

The selected solution for the case study is **GitHub Copilot** used as a repository-integrated AI coding assistant. This choice is not based on brand popularity alone. It is based on fit to the project requirements and on the current evidence base.

## Why GitHub Copilot is the most defensible choice

The first reason is evidentiary support. Among current tools, GitHub Copilot is one of the few for which there is both controlled academic evidence and enterprise field evidence. Peng et al. provide a controlled productivity result showing a 55.8% faster completion time for the treated group [1]. GitHub’s work with Accenture adds enterprise telemetry and survey evidence, including rapid adoption, increased pull requests, increased successful builds, and improved developer experience [3]. Cisco’s real-world project study adds an important nuance by showing substantial gains on repetitive and supportive tasks while documenting clear limits in complex or context-heavy settings [11]. Taken together, this gives Copilot a stronger justification than tools that are discussed mainly through anecdote.

The second reason is workflow integration. The project requires a case study that can be implemented, explained, and demonstrated. Copilot operates directly inside a developer workflow, which makes it easier to show how suggestions emerge from repository context and how they are accepted, rejected, or modified. This is preferable to a browser-only workflow, where the connection between prompt, code, and final change is harder to trace.

The third reason is methodological clarity. Because Copilot is an assistant rather than a full autonomous agent, the team can more easily separate what the tool contributed from what the developers still had to do. This supports a more rigorous reflection. If a fully agentic system were chosen, the resulting process would be harder to analyze cleanly because the system’s planning, tooling, and execution layers would all interact.

## Why other solutions were not selected

A general-purpose browser chat workflow was not selected as the primary solution because it is weaker on repository grounding and more exposed to context loss. It may still be used as a secondary support tool for explanation or brainstorming, but it is less appropriate as the main object of evaluation. The literature on over-trusting articulate but incorrect answers makes this a non-trivial concern [2].

A highly autonomous agentic workflow was not selected as the primary solution because it adds too much variance for the scope of this project. Gartner’s analysis suggests that AI agents are strategically important, but it also highlights new challenges in security, role redesign, and risk management [6]. For a short ASE project, a repository-integrated assistant allows a clearer and more defensible experiment.

## Expected strengths of the selected solution

Based on the literature, the team should expect GitHub Copilot to be most useful in tasks such as drafting an initial implementation, generating or expanding tests, completing boilerplate, proposing small refactorings, explaining local code regions, and accelerating movement through familiar patterns [1], [3], [11]. These are exactly the kinds of bounded tasks that make sense in a classroom case study.

## Expected weaknesses of the selected solution

The team should also expect failure modes. Copilot may generate superficially plausible code that does not fit project conventions, miss hidden edge cases, produce shallow tests, or fail to understand broader architectural constraints. It may be much stronger in local completions than in cross-file reasoning. These are not side issues; they are part of the reason the tool is worth studying [2], [11].

## Decision summary

GitHub Copilot was selected because it offers the best balance of practical relevance, evidence, repository integration, and analytical clarity. It is realistic enough to matter, but bounded enough to evaluate critically.
