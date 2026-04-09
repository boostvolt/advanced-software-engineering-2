# Task 2 - Reflection on Trade-offs, Difficulties, and Gaps

## Important note

This document is intentionally written in a mixed format. The analytical parts are complete and can already be used. The short passages marked with `TODO` must be replaced after the implementation is actually performed. They cannot be filled responsibly in advance.

## Why the selected solution was chosen

GitHub Copilot was selected because it is the strongest compromise between evidence, practicality, and analytical clarity. The literature indicates that repository-integrated AI assistance can generate real productivity gains on bounded tasks [1], [3], [11]. At the same time, the same literature makes clear that benefits are uneven and that context-heavy reasoning remains difficult [2], [11]. This makes Copilot a good object of study for a case that aims to reveal both gains and gaps.

A browser-chat workflow was discarded as the primary solution because it is weaker on repository grounding and more exposed to context loss and governance concerns [2], [10]. More agentic systems were discarded as the primary solution because they introduce additional autonomy and variance that would make the case study harder to analyze rigorously within the scope of the course [6].

## How the implementation experience should be written up

Once the implementation is complete, this section should explain the experience in a sober and concrete way. The most useful structure is chronological. Start with the task and repository context. Then explain where Copilot helped immediately, where it produced misleading or incomplete output, and where the humans had to intervene.

A strong write-up would say something like the following, but with your own facts: the tool was useful in drafting an initial patch and producing test scaffolding, but less reliable in interpreting repository-specific conventions or hidden edge cases. This kind of conclusion would be consistent with the literature, but it must still come from your direct observations [11].

`TODO: Describe the actual repository, issue, and change implemented.`

`TODO: Describe the two or three most useful Copilot interventions during the task.`

`TODO: Describe at least one suggestion that was wrong, incomplete, or had to be reworked substantially.`

## Main difficulties likely to be relevant

Even before implementation, the literature lets us identify the most plausible categories of difficulty. The first is **context mismatch**. The tool may not fully understand project-specific behavior or naming conventions, especially in brownfield tasks [11]. The second is **shallow validation artifacts**. The tool may generate tests that look correct but cover only the obvious path. The third is **overconfident explanation**. A suggestion may sound well reasoned while still being based on a false assumption, which is consistent with the broader trust problem documented by Kabir et al. [2]. The fourth is **integration effort**. Even if a patch is generated quickly, additional effort may be needed to verify, clean up, or adapt it to repository expectations [12].

The final reflection should identify which of these difficulties actually occurred and which did not. That distinction matters because it shows that the team is reporting evidence rather than repeating general claims.

`TODO: Replace this paragraph with the difficulties that actually appeared in your task.`

## Major trade-offs

The literature suggests several trade-offs that the case study should evaluate directly.

The first trade-off is **speed versus certainty**. AI tools can reduce the time needed to draft a first solution, but the resulting uncertainty may require careful checking. In practice, this means the tool can compress the production of candidate code while leaving the burden of correctness with the human team [1], [2].

The second trade-off is **local usefulness versus global understanding**. Repository-integrated assistants tend to be strongest at the level of functions, tests, and localized edits. Their value decreases when the task requires reasoning across architectural boundaries or multiple interacting modules [11].

The third trade-off is **accessibility versus governance risk**. The more convenient the tool is to use, the easier it becomes for developers to rely on it routinely. But convenience also increases the risk of accidental exposure of sensitive context if boundaries are not clear, as the Samsung incident illustrates [10].

The fourth trade-off is **individual productivity versus coordination cost**. Open-source evidence suggests that project-level productivity can improve while integration time also rises [12]. For ASE, this is one of the most interesting trade-offs because it reminds us that faster local production does not automatically mean smoother collective delivery.

## Existing gaps

Several gaps remain visible in the field and should be discussed in the case study even if the local task appears successful.

The first gap is trustworthy system-level reasoning. Current tools are still much better at pattern completion than at reconstructing hidden architectural intent. The second gap is evaluation. Organizations still lack universally accepted ways to measure whether AI assistance improves outcomes at the right level. The third gap is governance. Productive use in non-public repositories requires tool approval, data boundaries, and organizational policy. The fourth gap is skill development. AI can reduce friction, but it may also alter how developers learn, especially in large systems where understanding is hard-earned [5], [9].

## Can these gaps be solved?

Some gaps can be reduced substantially, but they are unlikely to disappear completely in the near term. Better repository retrieval, richer in-context documentation, stronger tests, approval workflows, and safer enterprise toolchains can all make AI assistance more reliable and more governable. Human roles will probably shift rather than vanish. Gartner’s and Deloitte’s analyses both point toward more orchestration, oversight, and AI-augmented team structures rather than a clean substitution of engineers by models [5], [9].

The most reasonable conclusion for the final version of this document is therefore not that AI can or cannot do software engineering. It is that AI changes the economics and structure of engineering work. It reduces some forms of effort, but increases the importance of review, judgment, context management, and governance.
