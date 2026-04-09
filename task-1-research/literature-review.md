# Task 1.2 - Literature Review

## Overview of the evidence base

The current evidence on AI-assisted SWE comes from three main types of sources. The first type is controlled academic research, which is useful for isolating effects. The second type is enterprise field evidence, which shows how tools behave inside real organizations. The third type is strategic industry analysis, which helps interpret how tooling changes may alter software engineering roles and structures over time. A balanced review requires all three.

## Controlled productivity evidence

The most frequently cited empirical study is the GitHub Copilot experiment by Peng et al. Participants were asked to implement an HTTP server in JavaScript as quickly as possible. The treatment group with access to Copilot completed the task 55.8% faster than the control group [1]. The study is important because it provides a concrete causal result rather than a purely observational claim. It supports the proposition that AI assistance can improve speed on bounded programming tasks.

At the same time, the scope of that finding should be interpreted carefully. The task was constrained, and the study does not imply that complex brownfield development, architectural work, or long-horizon maintenance become equally easy. Its real value lies in proving that the productivity signal is real, not in proving that the effect is universal.

## Evidence on answer quality and trust risk

Kabir et al. provide one of the clearest warnings in the literature. Their empirical study of ChatGPT answers to Stack Overflow questions found that 52% of answers contained incorrect information and 77% were verbose [2]. Human evaluators still preferred many of these answers because they were comprehensive and well phrased, and misinformation was frequently overlooked [2].

This paper is important even though it is about programming Q&A rather than IDE completion. The underlying issue is the same: AI outputs can appear more reliable than they are. In software engineering practice, this creates a non-trivial risk of over-trust. The paper therefore contributes less to the question of speed and more to the question of safe adoption.

## Enterprise evidence from GitHub and Accenture

GitHub’s research with Accenture is especially useful because it moves from laboratory settings into enterprise workflows. The study reports that more than 80% of Accenture participants successfully adopted Copilot, that 67% used it at least five days per week, that developers saw an 8.69% increase in pull requests, and that successful builds increased by 84% [3]. It also reports significant improvements in developer satisfaction and perceived job fulfillment [3].

This source is valuable for two reasons. First, it shows that AI assistance can matter at organizational scale rather than only in experimental settings. Second, it highlights that developer experience is itself an important outcome. Reduced search time, lower mental effort on repetitive tasks, and better ability to stay in flow are engineering-relevant effects because they influence throughput and sustainability [3].

However, because this is vendor-associated research, it should be read critically. It is persuasive as evidence that the tools can create value, but not as proof that the value appears in every context or for every task. That is why it is useful to pair it with independent academic work.

## Real-world project evidence on limitations

Pandey et al. studied Copilot in real-world projects and found meaningful time savings in several areas, including documentation, repetitive coding, unit tests, debugging, and pair programming, with projected coding-related time reduction in the range of 33% to 36% [11]. The strength of this study is that it does not only report gains. It also specifies where the tool underperforms: complex tasks, large functions, multi-file work, and proprietary contexts [11].

This is one of the most practically useful papers for the present project because ASE is concerned with complex systems, not toy examples. The study supports a nuanced position: AI assistance is valuable, but the benefits are uneven and degrade when systemic complexity becomes dominant.

## Evidence from collaborative open source

Song et al. extend the discussion from individual developer tasks to collaborative open-source development. They report that Copilot increased project-level productivity by 6.5%, individual productivity by 5.5%, and participation by 5.4%, but also increased integration time by 41.6% [12]. They found no change in code quality overall [12].

This result is important because it reveals a coordination trade-off. More output does not automatically mean less total effort. In collaborative settings, integration, review, and coordination can absorb some of the gains. For a project on large systems, this is an especially valuable insight because it moves beyond the naive equation “faster typing = better engineering.”

## Strategic industry interpretation

Gartner’s 2025 software-engineering trends statement argues that by 2028, 90% of enterprise software engineers will use AI code assistants and that developer work will shift from direct implementation toward orchestration and system design [5]. Gartner’s discussion of AI agents extends this logic by suggesting that AI will increasingly smooth friction points across the SDLC while also introducing new vulnerabilities and role changes [6].

Deloitte’s 2026 software outlook reaches similar conclusions from an industry-strategy perspective. It argues that software creation is becoming faster and cheaper in the agentic AI era, that firms are moving from adding isolated AI features toward AI-first engineering and product design, and that development teams are likely to be redesigned into smaller, AI-augmented teams [9]. Deloitte also notes concerns about mentorship and collaboration, suggesting that AI may alter how engineers learn and interact [9].

These sources are not substitutes for technical evidence, but they are important because they frame the likely organizational consequences of the technical shift. They help explain why AI-assisted SWE is not just a temporary tooling trend.

## Synthesis

Across the literature, a clear pattern appears. First, AI assistance provides real productivity gains on bounded tasks [1], [11]. Second, correctness and trust remain unresolved problems [2]. Third, enterprise and collaborative evidence shows that gains coexist with coordination and integration costs [3], [12]. Fourth, industry analysis suggests that the impact will extend from coding into team structure, workflows, and governance [5], [6], [9].

The most defensible overall conclusion is therefore the following: AI-assisted SWE is neither mere hype nor a drop-in replacement for engineering expertise. It is a productivity-amplifying but context-sensitive technology whose value depends on how well teams control validation, integration, risk, and organizational learning.
