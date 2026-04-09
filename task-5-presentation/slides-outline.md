# Task 5 – Presentation Outline
## AI-Assisted Software Engineering in Large Complex Systems
### ASE – Team 08

This file contains the slide-by-slide content for the final presentation. It is written to match the project requirements: a clear introduction, the main results from Task 1 and Task 2, five lessons learned, a ten-minute class activity, and a short transition to the discussion phase. The intended audience is academic, but with practical software engineering experience. For that reason, the content emphasizes evidence, engineering judgment, trade-offs, and concrete implications rather than generic enthusiasm about AI tools.

---

## Slide 1 – Title

**AI-Assisted Software Engineering in Large Complex Systems**  
ASE – Team 08

Suggested spoken framing:

This presentation examines AI-assisted software engineering not as a marketing trend, but as an engineering challenge. Our goal was to understand where AI tools are genuinely useful in software development, where they fail, and which trade-offs become visible once such tools are applied to a practical case study in a realistic workflow.

---

## Slide 2 – Why this topic matters now

AI-assisted software engineering matters because software teams increasingly work in environments defined by complexity rather than isolated coding effort. Large systems contain hidden assumptions, architectural constraints, legacy code, multiple stakeholders, and organizational rules. In this setting, development effort is often spent on understanding, navigating, validating, and coordinating changes rather than only writing new code. AI tools are relevant because they promise to reduce friction in many of these tasks.

This is no longer a marginal development. GitHub’s Octoverse reporting shows that generative AI has become a mainstream part of software development activity, with more than 1.1 million public repositories using an LLM SDK and 80% of new developers on GitHub using Copilot in their first week [5], [6]. Gartner similarly frames AI-native engineering as a top strategic trend and predicts that by 2028, 90% of enterprise software engineers will use AI code assistants [7]. This means the topic is not simply about a tool choice; it is about a shift in engineering practice.

Suggested concise slide text:

AI-assisted SWE matters because:
- software systems are increasingly large and interdependent
- developers spend major effort on understanding and validation
- AI tools are moving into mainstream engineering workflows
- the real question is not only productivity, but trust, fit, and control

---

## Slide 3 – Topic definition

AI-assisted software engineering refers to the use of AI systems to support software engineering tasks such as code generation, comprehension, test creation, documentation, refactoring, review assistance, and issue resolution. In practice, the field spans a spectrum from local assistants embedded in an IDE to more agentic systems capable of planning and executing larger workflows.

For this project, we focus on AI assistance within bounded development workflows. This means we are not asking whether AI can replace software engineers. We are asking whether it can support engineers productively and safely in realistic engineering tasks. This framing is important because it keeps the analysis grounded in software engineering rather than in abstract speculation.

Suggested concise slide text:

AI-assisted SWE = AI support for engineering tasks  
Our focus:
- bounded developer workflows
- code, tests, understanding, review
- usefulness under real constraints
- not replacement, but engineering support

---

## Slide 4 – Main motivations from Task 1

The first motivation is productivity. A controlled study on GitHub Copilot found that participants completed a programming task 55.8% faster than the control group [1]. This does not settle the entire question, but it provides credible evidence that AI assistance can reduce effort on bounded tasks.

The second motivation is adoption at scale. GitHub’s research with Accenture and customer evidence from Duolingo show that AI-assisted development is already being integrated into real software teams. Reported outcomes include higher pull-request volume, faster review turnaround, and improved build success [3], [4].

The third motivation is strategic relevance. Gartner and Deloitte both argue that AI is reshaping software engineering roles, workflows, and operating models [7], [10]. This makes AI-assisted SWE relevant not only as a coding aid, but as a question about future engineering practice.

Suggested concise slide text:

Main motivations:
- measurable productivity gains on bounded tasks [1]
- real industry adoption in engineering teams [3], [4]
- strategic shift in software engineering practice [7], [10]

---

## Slide 5 – Main challenges from Task 1

The strongest challenge is trust. Research on ChatGPT answers to Stack Overflow questions found that 52% contained incorrect information and 77% were verbose, even though many users still preferred them because they sounded helpful and complete [2]. This is especially dangerous in software engineering because plausible output can still be wrong.

A second challenge is context. Large systems depend on domain knowledge, hidden architecture constraints, repository conventions, and operational history. AI assistance is often strongest on local prediction and weaker when success depends on broad system understanding.

A third challenge is governance. The Samsung case is important because it shows that productivity and safety cannot be separated. After sensitive code was uploaded to ChatGPT, Samsung restricted the use of such tools on company devices until safer measures were in place [9].

Suggested concise slide text:

Main challenges:
- plausible but incorrect output [2]
- weak system-level context
- security and governance risks [9]
- difficulty measuring real value
- review effort does not disappear

---

## Slide 6 – Industry use cases

Duolingo provides an example of productivity-oriented adoption. GitHub reports that the company observed a 25% increase in developer speed, a 67% decrease in median code review turnaround time, and a 70% increase in pull requests after using Copilot [4]. This is useful because it suggests benefits beyond code completion alone.

Accenture provides a larger enterprise perspective. GitHub’s enterprise study reported strong adoption and improvement in indicators such as pull requests, merge rate, and successful builds [3]. This shows that AI assistance can be integrated into large organizational workflows when there is enough support, tooling, and measurement.

Samsung provides the counterexample. Its restriction on ChatGPT after a code leak shows that AI assistance is also a governance problem, not only a productivity opportunity [9].

Suggested concise slide text:

Three contrasting use cases:
- Duolingo: speed and review-cycle gains [4]
- Accenture: enterprise-scale adoption and workflow impact [3]
- Samsung: governance and leakage risk [9]

---

## Slide 7 – Our case study and research question

Our case study asks a narrow but important question: can a repository-integrated AI coding assistant improve the speed and usefulness of a bounded maintenance task without creating unacceptable correctness, review, or governance risks?

We intentionally did not test the strongest possible autonomy claim, such as asking whether an agent can build a full system. Instead, we selected a realistic software engineering task in an open-source repository and evaluated AI assistance in the following sequence: understanding the relevant code, drafting a change, proposing or refining tests, reviewing the output, and reflecting on the limitations.

This design fits the available evidence. The literature supports productivity gains on bounded tasks [1], but it also warns against over-trust and context blindness [2], [7]. Our case study therefore focuses on the point where productivity and engineering judgment meet.

Suggested concise slide text:

Case study question:
Can a repository-integrated assistant help on a bounded task
without reducing correctness, trust, or control?

Scope:
- understand code
- draft change
- improve tests
- review critically
- reflect on trade-offs

---

## Slide 8 – Solution comparison and selection

We considered three categories of solutions. Browser-based chat tools are flexible and good at explanation, but they are weakly integrated with the repository and increase the risk of context loss. Agentic tools are promising, but they introduce more autonomy, more variance, and more evaluation difficulty. Repository-integrated assistants sit between those two extremes.

We selected GitHub Copilot because it offers the best balance of evidence, reproducibility, and realistic workflow integration. It is supported by a controlled productivity study [1], enterprise results with Accenture [3], and customer evidence from Duolingo [4]. More importantly, it is embedded directly in the coding workflow, which makes it suitable for analyzing the interaction between AI drafting and human review.

Suggested concise slide text:

Why repository-integrated assistance?
- more grounded than browser chat
- more controlled than agentic autonomy
- easier to evaluate in a real workflow
- stronger evidence base [1], [3], [4]

---

## Slide 9 – Main results from Task 2

Our case study suggests that AI assistance is most useful on bounded, local, and repetitive tasks. It helped reduce friction in code understanding, boilerplate drafting, and test scaffolding. These benefits are real, but they are conditional.

The main limitation is that speed does not remove review effort. Suggestions often looked plausible before they were validated against repository conventions, edge cases, and actual task intent. In this sense, the bottleneck shifted from drafting to validation. This is exactly the pattern suggested by the broader literature: AI can make first drafts cheaper, but it does not eliminate engineering judgment [1], [2], [7].

Suggested concise slide text:

Observed pattern:
- AI helps on bounded local tasks
- first drafts become faster
- review and validation remain essential
- context gaps are still visible

---

## Slide 10 – Trade-offs and gaps

The first trade-off is speed versus certainty. AI can reduce drafting time, but each gain in speed increases the importance of validation. The second trade-off is local fluency versus global understanding. Suggestions may work well inside one file while still missing architectural implications. The third trade-off is convenience versus governance. The easier it is to ask for help, the easier it becomes to normalize unsafe usage.

The major gaps are also clear. Current tools still struggle with trustworthy system-level reasoning. Measurement of real productivity remains difficult. Governance and approved usage models are necessary. These gaps can be reduced with better context integration, stronger tests, and safer workflows, but they are not fully solved.

Suggested concise slide text:

Trade-offs:
- speed vs certainty
- local usefulness vs system context
- convenience vs governance

Persistent gaps:
- system-level reasoning
- trustworthy validation
- measurement
- policy and control

---

## Slide 11 – Five lessons learned

The first lesson is that AI assistance works best when the task is bounded and well specified. The second is that polished output is not a substitute for correctness. The third is that review effort does not disappear; it changes character. The fourth is that system context determines usefulness more than raw model fluency. The fifth is that governance matters as much as productivity when the engineering environment is large, collaborative, or sensitive.

Suggested concise slide text:

Five lessons learned:
1. bounded tasks benefit most
2. plausible is not the same as correct
3. review remains essential
4. context quality drives usefulness
5. governance is part of engineering

---

## Slide 12 – Activity introduction

We now move from explanation to participation. The purpose of the activity is to let the class experience the central tension of AI-assisted SWE directly: the difference between fast output and trustworthy output.

Participants will receive a short software-engineering scenario together with two review comments. One will sound efficient and convincing but overlook a key issue. The other will be more cautious and emphasize validation, uncertainty, or hidden context. The task is to decide which review is more trustworthy and explain why.

Suggested concise slide text:

Activity:
- evaluate two reviews for one engineering scenario
- choose the more trustworthy one
- justify your decision
- connect it to AI-assisted SWE

---

## Slide 13 – Activity execution

Distribute the scenario cards. Give the class four minutes to discuss. Ask each group to answer one question: which review would you trust if you had to approve this change for production?

After the discussion, collect quick responses from each group. The objective is not to identify who is “for” or “against” AI. The objective is to see that good engineering judgment usually appears where someone asks for evidence, tests, or clarification rather than simply accepting a polished answer.

Suggested concise slide text:

Question:
Which review would you trust before approving a production change, and why?

---

## Slide 14 – Activity debrief

The activity reinforces our main conclusion. AI-assisted software engineering should not be understood as automatic engineering. It is better understood as assisted drafting under human judgment. The more convincing the output looks, the more carefully engineers must ask whether it is correct, complete, secure, and context-appropriate.

This is why the topic belongs in Advanced Software Engineering. The technical issue is not merely generation, but integration into complex systems and decision processes.

Suggested concise slide text:

Main takeaway:
AI changes where effort goes.
Less effort on first drafts.
More responsibility in review, validation, and control.

---

## Slide 15 – Closing

Our conclusion is not that AI should be rejected, and not that it should be accepted uncritically. The stronger conclusion is that AI should be integrated selectively, critically, and with explicit human oversight. In large complex systems, it acts as a productivity amplifier under constraints, not as a substitute for engineering judgment.

Thank the audience and transition to the discussant team.

Suggested concise slide text:

Conclusion:
AI-assisted SWE is useful, but only under disciplined review,
good context, and clear governance.

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
