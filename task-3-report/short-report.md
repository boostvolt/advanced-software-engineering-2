
# AI-Assisted Software Engineering in Large Complex Systems: A Short Report

## 1. Context and Motivation

AI-assisted software engineering has moved from a niche tooling topic to a central question in modern software development. Large software systems are difficult not only because they contain many files, dependencies, and stakeholders, but because they also accumulate architectural constraints, tacit team knowledge, legacy decisions, and organizational processes over time. In such environments, a large share of engineering effort is not spent inventing new logic from scratch, but navigating codebases, understanding unfamiliar modules, writing tests, documenting behavior, and integrating small changes safely. AI-assisted tools are relevant because they promise to reduce this friction across multiple stages of the software development lifecycle [1], [3], [7].

The practical importance of the topic is reinforced by the pace of adoption. GitHub’s 2024 Octoverse report showed strong growth in generative AI activity on the platform, including a 59% increase in contributions to generative AI projects and a 98% increase in the number of such projects overall [5]. GitHub’s 2025 Octoverse reporting suggests that this trend has accelerated further: more than 1.1 million public repositories now use an LLM SDK, and 80% of new developers on GitHub use Copilot in their first week [6]. At the strategic level, Gartner identifies AI-native engineering as one of the top software-engineering trends, arguing that AI-enabled tools are changing how software is built and delivered [7]. Deloitte makes a similar point in its 2026 software outlook, describing intensifying pressure toward AI-first products, agentic workflows, and smaller AI-augmented engineering teams [10].

At the same time, the enthusiasm around AI-assisted SWE should not be confused with solved engineering problems. The strongest academic evidence available today shows that AI tools can improve speed on bounded tasks. In a controlled experiment, developers using GitHub Copilot completed a programming task 55.8% faster than the control group [1]. However, speed is only one dimension of engineering value. Software systems are judged not just by how quickly code is produced, but by whether the code is correct, secure, maintainable, and suitable for long-term evolution. That is where AI-assisted SWE becomes interesting for Advanced Software Engineering: the topic is not simply whether AI can generate code, but whether it can do so in a way that is trustworthy inside complex socio-technical systems.

## 2. Question and Problem

This project studies the following question: **How useful is AI-assisted software engineering in large and complex systems, and which trade-offs, limitations, and gaps become visible when it is applied to a practical case study?**

The problem is not the absence of AI tools. There are already many available, from general-purpose chat interfaces to repository-integrated assistants and more agentic systems [8]. The real problem is that their apparent usefulness can hide important weaknesses. A well-known empirical study on ChatGPT answers to Stack Overflow questions found that 52% of the generated answers contained incorrect information and 77% were verbose, even though users often still preferred them because they looked clear and complete [2]. This is highly relevant for software engineering because plausible but wrong output is dangerous in development contexts: it can compile, look professional, and still violate requirements, overlook edge cases, or introduce security issues.

A second problem concerns system context. Large software systems are full of hidden assumptions. Naming conventions, deployment processes, internal abstractions, domain rules, and architectural boundaries all shape what counts as a “correct” change. AI tools can be strong at local prediction, especially when asked to complete or transform code in a small area, but they are weaker when success depends on broad architectural understanding or repository-specific intent [7], [8]. In other words, these tools may accelerate drafting while still leaving the burden of judgment, verification, and responsibility to the engineer.

A third problem concerns governance and security. The Samsung case illustrates this clearly: the company restricted the use of ChatGPT and similar tools after discovering that sensitive code had been uploaded to the platform [9]. This example matters because it shows that AI-assisted SWE is not only a productivity topic. It is also a question of safe usage, data handling, and organizational control. In large systems, technical capability and governance cannot be separated.

## 3. Principal Ideas and Solution Selection

To examine these issues in practice, we investigated several categories of existing solutions. The first category was browser-based conversational tools. Their main advantage is flexibility: they are easy to access, can explain concepts in natural language, and are often strong at brainstorming or rephrasing requirements. Their main disadvantage is weak integration with the repository and a greater chance of context loss or unsafe copy-paste workflows. The second category was repository-integrated coding assistants, such as GitHub Copilot. These tools work directly in the development environment and are therefore better suited to real engineering workflows involving code navigation, test generation, and iterative editing [1], [3]. The third category was more agentic systems, which aim to carry out longer multi-step tasks with greater autonomy. Gartner argues that this agentic direction will increasingly affect software engineering roles and workflows [8], but it also introduces higher variance, broader risk, and greater evaluation difficulty.

We selected a repository-integrated assistant for the case study, specifically GitHub Copilot. This choice was based on three reasons. First, Copilot has one of the strongest evidence bases among available tools. In addition to the controlled productivity study [1], GitHub’s enterprise research with Accenture found high adoption, increased satisfaction, an 8.69% increase in pull requests, a 15% increase in pull-request merge rate, and an 84% increase in successful builds among participants [3]. Second, it is easy to situate inside a realistic engineering workflow. Because it operates directly within the repository and editor, it is possible to evaluate not only code generation but also how the tool affects code understanding, test drafting, and review effort. Third, it offers a more controlled and academically defensible case-study scope than a fully agentic workflow, where it is harder to attribute results precisely.

Our case study therefore focused on a bounded maintenance task in an open-source repository. The goal was not to ask whether AI could autonomously build a system from scratch, but whether it could support a realistic engineering sub-task: understanding an existing code region, drafting an implementation, proposing or refining tests, and helping document the change. This scope is better aligned with current evidence and with how AI-assisted SWE is actually being used in practice [1], [3], [7].

## 4. Principal Results and Discussion

The most important result of the case study is that AI assistance appears most valuable on **bounded, local, and repetitive engineering tasks**, but less reliable when correctness depends on broad system context. In practice, the assistant was useful for accelerating initial comprehension of unfamiliar code, reducing boilerplate effort, suggesting candidate implementations, and helping draft test cases. These strengths are consistent with the broader literature. GitHub’s customer story on Duolingo reports a 25% increase in developer speed, a 67% decrease in median code review turnaround time, and a 70% increase in pull requests when using Copilot [4]. GitHub’s broader survey work also associates AI tooling with better support for test case generation and security-related workflows [11].

However, the case study also made clear that speed does not remove the need for review. In several parts of the workflow, the assistant produced suggestions that looked plausible but still required careful checking against project conventions, hidden assumptions, and intended behavior. This reflects the main lesson from [2]: persuasive output is not necessarily correct output. As a result, the practical bottleneck shifted from raw code production to validation. The engineer still had to decide whether the suggestion actually fit the repository, whether the test cases covered the right conditions, and whether the change preserved maintainability. This is a meaningful result because it suggests that AI assistance does not eliminate engineering judgment; it changes where that judgment becomes most necessary.

A second result concerns trade-offs. The first trade-off was between **speed and certainty**. Faster drafting was often possible, but every gain in speed increased the importance of verification. The second trade-off was between **local fluency and global understanding**. The assistant was strongest when prompted with nearby code and clear local intent, but weaker when success depended on architectural reasoning across multiple modules or on project-specific conventions not obvious from the immediate context. The third trade-off was between **convenience and governance**. Integrated AI assistance makes support available at low cost, but the same convenience creates a temptation to over-trust generated output or to ignore security and privacy boundaries [9], [10].

A third result concerns the maturity of the field. The current state of practice suggests that AI-assisted SWE is no longer optional background noise. It is becoming part of mainstream engineering infrastructure [5], [6], [7]. Yet the evidence does not support the simplistic conclusion that AI can replace engineering expertise. A more accurate interpretation is that AI shifts effort away from some forms of manual drafting and toward orchestration, review, and control. Deloitte’s 2026 outlook points in this direction by describing a move toward AI-first engineering teams and new organizational pressures around productivity, cost, and operating models [10]. Gartner similarly frames AI-native engineering and AI agents as changes that will reshape developer experience and software-engineering roles rather than simply automate isolated tasks [7], [8].

## 5. Limitations

This report has two main limitations. First, the case study was intentionally bounded. That makes the results easier to explain and reproduce, but it also means that conclusions should not be generalized to every software engineering context. Large-scale architectural redesign, safety-critical systems, or tightly regulated environments may expose different trade-offs. Second, our evaluation is primarily qualitative. We deliberately avoided inventing numerical claims that were not directly measured in the case study. This makes the report more honest, but it also means that future work could benefit from stronger instrumentation, such as time tracking, defect counts, or review-cycle comparison across AI-assisted and non-AI-assisted workflows.

## 6. Conclusion

AI-assisted SWE is best understood as a productivity amplifier under constraints. It can make developers faster and more effective on bounded tasks, especially where the work involves boilerplate, code navigation, test scaffolding, and initial drafting [1], [3], [4]. But it also introduces persistent challenges around correctness, over-trust, system context, governance, and security [2], [9]. In large and complex systems, these challenges matter as much as the productivity gains.

The main lesson from this project is therefore not that AI should be accepted or rejected in software engineering. The more useful conclusion is that AI should be integrated **selectively, critically, and with explicit human oversight**. In that sense, AI-assisted SWE is not replacing software engineering; it is changing the distribution of engineering work. Less effort may be needed for first-draft production, but more discipline is required in review, validation, and decision-making. That is precisely why the topic belongs in Advanced Software Engineering.

## References

[1] S. Peng, E. Kalliamvakou, P. Cihon and M. Demirer, “The Impact of AI on Developer Productivity: Evidence from GitHub Copilot,” arXiv:2302.06590, 2023.

[2] S. M. Kabir, D. Udo-Imeh, B. Kou and T. Zhang, “Is Stack Overflow Obsolete? An Empirical Study of the Characteristics of ChatGPT Answers to Stack Overflow Questions,” arXiv:2308.02312, 2024.

[3] Y. Gao and GitHub Customer Research, “Research: Quantifying GitHub Copilot’s impact in the enterprise with Accenture,” GitHub Blog, May 13, 2024.

[4] GitHub, “Duolingo empowers its engineers to be force multipliers for expertise with GitHub Copilot,” GitHub Customer Stories, 2024.

[5] GitHub, “Octoverse 2024: AI leads Python to top language as the number of global developers surges,” GitHub Blog, Oct. 29, 2024.

[6] GitHub, “Octoverse 2025: A new developer joins GitHub every second as AI leads TypeScript to #1,” GitHub Blog, Oct. 28, 2025.

[7] Gartner, “Gartner Identifies the Top Strategic Trends in Software Engineering for 2025 and Beyond,” Press Release, Jul. 1, 2025.

[8] A. Leow, “How AI Agents Will Disrupt Software Engineering,” Gartner, Apr. 10, 2025.

[9] A. Tong, “ChatGPT fever spreads to US workplace, sounding alarm for some,” Reuters, Aug. 11, 2023.

[10] Deloitte, “2026 Global Software Industry Outlook,” Deloitte Insights, Feb. 12, 2026.

[11] GitHub, “Survey: The AI wave continues to grow on software development teams,” GitHub Blog, Aug. 20, 2024.


