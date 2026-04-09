
# Task 4 – Activity Description

## Title
**Human Judgment Under Pressure: Evaluating AI-Assisted SWE**

## Purpose

The purpose of this activity is to help the class understand one of the central findings of our project: the main challenge of AI-assisted software engineering is not only generating code quickly, but evaluating whether the generated output is actually correct, secure, and appropriate in context. Research on AI-assisted development shows that such tools can improve productivity on bounded tasks [1], and industry evidence suggests that they are increasingly embedded in everyday workflows [3], [5], [6]. At the same time, empirical work shows that AI-generated answers can be persuasive yet wrong [2], and real-world incidents such as the Samsung case show that careless use can create security and governance problems [9]. The activity is designed to make these tensions visible in a short, interactive format.

## Core Idea

Participants are placed in the role of reviewers. Each group receives a short pseudo-code change or engineering scenario, together with two short review responses. One response sounds polished and efficient but misses a crucial issue. The other response is more cautious and points to a risk, missing edge case, or contextual dependency. The class must decide which response they would trust, justify their decision, and explain what additional evidence they would require before approving the change.

The activity is intentionally simple. It does not test who can spot syntax errors fastest. Instead, it asks participants to behave like software engineers in a realistic situation: under time pressure, with incomplete context, and with outputs that look superficially plausible. This directly reflects the main theme of AI-assisted SWE in complex systems.

## Learning Goal

By the end of the activity, participants should understand that AI-assisted development changes the review process more than it eliminates it. The value of AI is often highest in drafting and acceleration, but the responsibility for correctness, validation, and judgment remains human. This conclusion is consistent with the literature reviewed in our project [1], [2], [7], [8].

## Duration

The activity lasts approximately ten minutes.

The first two minutes are used to explain the setup and distribute the material. The next four minutes are used for small-group discussion. The following three minutes are used for rapid class-wide feedback. The final minute is used to connect the discussion back to the case study and the broader lessons of the project.

## Procedure

We begin by telling the class that they are acting as reviewers on a software team that has started using AI assistance regularly. Each group receives one short scenario card. The scenario contains a change proposal and two review comments labeled only as **Review A** and **Review B**. Participants are asked to decide which review they find more trustworthy and why.

They are not asked which review is “nicer,” “faster,” or “more complete.” They are asked which review would make them more confident shipping the change. This distinction is important, because the activity is about engineering judgment rather than rhetorical fluency.

After the small-group discussion, each group shares its decision in one sentence. We then reveal the intended lesson of the card. In every case, the exercise is designed so that the stronger answer is the one that explicitly acknowledges uncertainty, asks for validation, or points to a hidden dependency. This reinforces the project’s core result: in AI-assisted SWE, correctness often depends less on how polished a suggestion looks and more on whether someone has asked the right follow-up questions.

## Why This Activity Fits the Topic

The activity is tightly aligned with our project findings. Task 1 showed that AI-assisted SWE is attractive because it can reduce friction and accelerate coding work [1], [3], [4]. It also showed that persuasive output can be unreliable and that governance matters [2], [9]. Task 2 translated that into practice by demonstrating that AI support was most useful on bounded tasks, while final correctness still depended on manual checking and contextual understanding. The activity gives the class a compact way to experience that same tension for themselves.

## Expected Outcome

The expected outcome is not that participants leave the room more skeptical of AI in general. The goal is more precise. Participants should leave with a better sense that AI-generated software suggestions must be reviewed as engineering artifacts, not consumed as authoritative answers. In other words, the activity helps communicate that the central competency in AI-assisted SWE is not passive acceptance of output, but active evaluation of its fit, risk, and limits.

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

