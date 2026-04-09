# Task 5 – Speaker Notes
## AI-Assisted Software Engineering in Large Complex Systems

This file contains the presenter notes for the final ASE presentation. It is intentionally more detailed than the slide text so that the delivery remains coherent even if the slides themselves are visually minimal. The structure below follows the expected presentation format: ten minutes of input, ten minutes of class activity, and five minutes for discussion by another team.

---

## General Presentation Strategy

The tone of the presentation should be analytical rather than promotional. The audience should understand that the project is not celebrating AI tools uncritically. It is evaluating them as engineering artifacts and as workflow interventions. This distinction matters because the strongest results in the literature concern bounded productivity gains [1], while the strongest warnings concern trust, context limits, and governance [2], [7], [9].

The presentation should also stay disciplined about scope. Avoid broad claims such as “AI will replace software engineers.” The more credible argument is that AI changes the allocation of effort inside software engineering: less effort on some forms of drafting, more effort on validation, system understanding, orchestration, and policy [7], [10].

---

## Opening (Slide 1)

Start with a simple framing: software engineering is already difficult in large systems because developers must deal with code complexity, human coordination, and hidden organizational constraints at the same time. AI-assisted SWE is therefore interesting not because it can generate snippets, but because it claims to reduce friction in precisely these demanding environments.

A good opening sentence is:

“We looked at AI-assisted software engineering as an engineering problem, not as a trend claim. Our question was where these tools help in real workflows, where they fail, and what trade-offs become visible when you actually use them.”

---

## Motivation (Slides 2–4)

When explaining why the topic matters, connect three levels of relevance.

At the first level, there is the direct productivity claim. The GitHub Copilot study reports a 55.8% faster completion time on a bounded programming task [1]. This is a strong result because it comes from a controlled experiment rather than anecdote.

At the second level, there is organizational adoption. GitHub’s work with Accenture and the Duolingo case show that AI-assisted development is already embedded in real workflows and associated with changes in review speed, pull-request activity, and successful builds [3], [4].

At the third level, there is strategic transformation. Gartner and Deloitte both argue that software engineering is shifting toward AI-native and AI-first operating models [7], [10]. Emphasize that this makes AI-assisted SWE important even for teams that are not yet fully invested in the tools, because the surrounding expectations and workflows are already changing.

---

## Challenges (Slide 5)

This is one of the most important slides because it protects the presentation from sounding naive.

The key message is that AI output can be persuasive while still being wrong. The Stack Overflow study is useful here because it captures exactly this problem: 52% of ChatGPT answers contained incorrect information and 77% were verbose, yet many users still preferred them [2]. Explain why this is dangerous in software engineering. A suggestion can compile, look clean, and still violate intent, miss an edge case, or introduce risk.

Then move to context. Explain that large systems are defined by information that is not obvious from a local code snippet: architecture, conventions, operational requirements, domain assumptions, and repository history. This is where AI tools tend to struggle most.

Finally, mention governance. The Samsung case is concise and memorable. It demonstrates that AI-assisted SWE is not only about output quality but also about safe usage boundaries [9].

---

## Use Cases (Slide 6)

Use the three use cases as a contrast set.

Duolingo represents the optimistic but concrete story. The reported 25% increase in developer speed and 67% decrease in code review turnaround time are useful because they connect AI to real software delivery processes, not only to code generation [4].

Accenture represents enterprise scale. The value of this case is that it suggests AI assistance can influence workflow metrics in large organizations, not just in isolated small teams [3].

Samsung represents the cautionary case. It shows that productivity gains are not enough when governance is weak [9].

The slide works best if you present these cases as evidence that AI-assisted SWE is neither purely beneficial nor purely harmful. It is useful under conditions and risky under others.

---

## Case Study and Solution Selection (Slides 7–8)

When introducing the case study, stress that the scope was deliberately narrow. This was not a test of full autonomy. It was a test of whether an AI coding assistant can help with a realistic bounded task in an open repository.

Then explain why a repository-integrated assistant was the best choice. Browser chat is more flexible but less grounded. Agentic tools are more autonomous but introduce more variance and make the evaluation noisier. A repository-integrated assistant offers the best compromise between realism and control.

This section should sound methodical. The project was not built around a favorite tool. The tool was selected because it best fit the project’s evaluation goals.

---

## Results and Trade-offs (Slides 9–10)

Present the results carefully. The strongest statement is not that AI produced better engineering by itself. The stronger and more defensible statement is that it reduced friction in bounded tasks while leaving system-level correctness dependent on human validation.

Explain that the tool helped with local understanding, boilerplate reduction, and test scaffolding. Then explain that apparent speed introduced a new burden: checking whether the suggestion was truly correct in context.

This is where the trade-off framing becomes useful. The audience should remember three tensions:
- speed versus certainty
- local usefulness versus global understanding
- convenience versus governance

Do not rush this part. It is the central analytical payoff of the project.

---

## Five Lessons Learned (Slide 11)

Deliver this slide as a compact synthesis of the whole project.

The first lesson is that bounded tasks benefit most.  
The second is that plausible output is not the same as correct output.  
The third is that review remains essential.  
The fourth is that context quality determines usefulness.  
The fifth is that governance is part of engineering, not an external afterthought.

If time is short, this is the one slide that should still remain intact.

---

## Activity Setup and Moderation (Slides 12–14)

The class activity is not an entertainment break. It is a compact demonstration of the project’s core argument.

Explain that each group will receive a software-engineering scenario and two short review comments. Their task is not to decide which response sounds more confident. Their task is to decide which one they would trust if they were approving a production change.

During the debrief, emphasize that the stronger answer is typically the one that asks for validation, points to uncertainty, or surfaces a hidden dependency. This connects directly back to the main project result: AI assistance changes the workflow by making first drafts cheaper, while making disciplined review even more important.

---

## Closing (Slide 15)

The final message should be balanced and clear:

“AI-assisted software engineering is best understood as a productivity amplifier under constraints. It can make bounded tasks faster and reduce friction, but it does not remove the need for engineering judgment. In large systems, that judgment becomes even more important.”

Then thank the audience and hand over to the discussant team.

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
