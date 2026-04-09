# Task 1.2 - Industry and Domain Use Cases

## Use Case 1: Duolingo as a positive case of bounded productivity gains

Duolingo is a useful case because it shows AI assistance deployed inside a real engineering organization rather than in an isolated experiment. GitHub’s customer story reports a 25% increase in developer speed, a 67% decrease in median code review turnaround time, and a 70% increase in pull requests after the introduction of GitHub Copilot [4]. These numbers should be interpreted with caution because they come from a customer success story, but they are still valuable as evidence of how AI can matter in day-to-day engineering workflows.

What makes this case relevant is not only the productivity signal. It also shows the specific mechanisms by which the gains can emerge. In practice, improvements of this kind usually come from reducing boilerplate work, shortening search loops, helping engineers maintain flow, and making it easier to draft changes and reviews. For a team working on a large product, that kind of acceleration can matter even if the AI is not making deep architectural decisions.

## Use Case 2: Accenture as a large-enterprise adoption case

Accenture is a stronger case for organizational scale. GitHub’s enterprise study reports rapid adoption, a 96% same-day success rate among users who installed the extension, 67% usage at least five days per week, an 8.69% increase in pull requests, and an 84% increase in successful builds [3]. The associated customer story further emphasizes that Copilot was particularly useful for writing tests and tackling technical debt [3].

This use case matters because it demonstrates that AI-assisted SWE is not restricted to small greenfield teams or hobby projects. In a large consulting and delivery environment, the value proposition is broader. AI can help developers move faster in unfamiliar parts of the codebase, reduce repetitive effort, and free capacity for higher-value work. At the same time, this case also reminds us that successful adoption requires structure: licenses, IDE integration, measurement, and organizational support. The tool alone is not the entire explanation.

## Use Case 3: Samsung as a cautionary governance case

Samsung is the most important counterexample in the topic. According to Bloomberg, Samsung restricted employee use of generative AI systems after employees uploaded sensitive code and information to ChatGPT [10]. This incident is widely cited because it illustrates a core governance issue in AI-assisted SWE: the same tool that increases convenience can also increase data exposure risk.

The relevance of the Samsung case goes beyond one company. It demonstrates that AI adoption in software engineering is constrained not only by model quality, but also by compliance, data handling, intellectual property protection, and policy design. In an academic setting, this is a valuable reminder that the engineering question is not just “does the tool help?” but also “under what operational conditions is its use acceptable?”

## Use Case 4: Open-source collaboration as a mixed case

Collaborative open-source development provides a different kind of use case because it exposes the tool to distributed review and integration processes. Song et al. found that GitHub Copilot increased project-level productivity by 6.5% and individual productivity by 5.5%, but also increased integration time by 41.6% [12]. This is a particularly useful case for ASE because it reveals a hidden trade-off. When more developers can produce changes more quickly, downstream coordination may become more demanding.

This case is significant because large complex systems often behave more like collaborative open-source projects than like isolated benchmark tasks. Multiple contributors, pull requests, reviews, and integration steps all interact. A tool that looks highly productive from the perspective of one person may generate different outcomes at the level of the project.

## Overall interpretation of the use cases

Taken together, the use cases support a balanced conclusion. Duolingo and Accenture show that AI-assisted SWE can create meaningful gains in speed, review turnaround, test creation, and developer experience [3], [4]. Samsung shows that the same class of tools can create governance and confidentiality problems when used without sufficient controls [10]. Open-source evidence shows that productivity gains may coexist with increased integration effort [12].

Therefore, the most accurate lesson from practice is not that AI assistance is universally good or bad. It is that the benefits are real, but they come with dependencies: task boundedness, context quality, review discipline, collaboration structure, and organizational governance.
