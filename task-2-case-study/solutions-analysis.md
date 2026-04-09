# Task 2 - Analysis of Existing Solutions

## Framing the solution space

The literature and current market suggest three broad categories of solutions for AI-assisted SWE. The first category is **general-purpose browser chat systems**, where developers copy code or questions into a standalone assistant. The second is **repository-integrated coding assistants**, which operate inside the IDE or code-hosting workflow. The third is **agentic coding systems**, which attempt to plan and execute larger multi-step tasks with less direct supervision. Each category addresses the same general need, but they do so with different trade-offs.

## Category 1: General-purpose browser chat assistants

The main strength of browser-based chat tools is flexibility. They are good at free-form explanation, brainstorming, reformulating documentation, and discussing alternative implementations. They can be useful when the developer needs a conceptual explanation or wants to compare approaches quickly.

However, this category has clear weaknesses for a case study on large systems. The first weakness is context fragility. Unless the developer manually provides the right files, the system cannot reliably infer the repository’s actual structure or constraints. The second weakness is governance. Copying code into a public or externally hosted chat environment may create confidentiality and compliance issues. The Samsung case shows how this can become a serious organizational risk [10]. The third weakness is trust. The Stack Overflow study indicates that well-written answers can still be wrong, which is particularly dangerous when the tool is detached from the repository and its tests [2].

For those reasons, browser chat systems are useful support tools, but they are not the best primary solution for a rigorous ASE case study focused on software engineering practice inside an existing repository.

## Category 2: Repository-integrated coding assistants

Repository-integrated assistants are currently the most pragmatic category for a case study. Their main advantage is workflow proximity. They operate where the work already happens: inside the editor, pull-request flow, or repository context. That reduces friction and makes it easier to connect suggestions to the real codebase. Research by Peng et al. and GitHub’s enterprise work with Accenture both support the idea that this category can deliver measurable gains in coding speed and developer experience [1], [3]. Real-world project evidence from Cisco also suggests strong usefulness for repetitive coding, documentation, debugging assistance, and unit tests [11].

The limitations of this category are equally important. Repository-integrated tools still do not guarantee architectural understanding or system-level correctness. They remain most effective on bounded local tasks and still require human review for correctness, maintainability, and alignment with project intent [11]. In other words, they improve the drafting layer of development more reliably than the decision layer.

From an ASE perspective, this category is the strongest candidate because it is realistic, easy to demonstrate, and easier to evaluate against actual repository artifacts than a free-floating chat interface.

## Category 3: Agentic coding systems

Agentic systems promise a larger step change. Instead of suggesting a function or explaining a file, they may attempt to inspect a repository, plan a task, edit multiple files, run validation, and propose a result. Gartner argues that AI agents are likely to smooth friction points across the SDLC and shift engineers toward more strategic work [6]. This makes the category highly relevant from a strategic point of view.

But for a classroom case study, the category also introduces significant problems. First, higher autonomy means higher variance. The quality of the result depends not only on the model, but also on the planning loop, tool permissions, repository access, and failure handling. Second, it becomes harder to attribute the observed result cleanly. Third, the risk profile is higher, especially if the system edits multiple files or performs actions that appear reasonable but are poorly grounded. These concerns are amplified by Gartner’s own warnings about security risks and role disruption [6].

Agentic systems are therefore very interesting analytically, but unless the team is explicitly studying autonomy itself, they are less suitable than repository-integrated assistants for a controlled and defensible case study.

## Comparative assessment

The most important comparison criterion is not raw capability but **fit to the project objective**. A good solution for this project should be easy to justify from the literature, usable within a repository-centered workflow, capable of supporting implementation and testing, and transparent enough that the team can explain both its successes and its failures.

Under those criteria, repository-integrated assistants are the strongest category. Browser chat tools are flexible but weakly grounded. Agentic tools are promising but add too much autonomy and variance for this project’s needs. A repository-integrated assistant offers the best balance between realism, boundedness, reproducibility, and evaluability.
