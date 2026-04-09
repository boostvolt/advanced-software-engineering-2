# Source evaluation: 12 candidate resources

We were given a list of 12 external resources to consider for the project. This file evaluates each one against our actual research questions: AI's effects on **code quality**, **code security**, the **code review bottleneck**, real world **incidents**, and **open source ecosystem effects**.

For each source: **what it is**, **what it actually contains**, and a **relevance verdict** (high, medium, low, or skip), with a one line "if we use it, here is what it would back up".

---

## Verdicts at a glance

| # | Source | Verdict | Best fit in our draft |
|---|---|---|---|
| 1 | Gartner, AI agents transforming SWE | **Low** | Generic context only |
| 2 | Gartner, Top strategic trends 2025 | **Medium** | The "AI-Native SWE" term and the 90% by 2028 adoption prediction |
| 3 | Peng et al. 2023 (Copilot RCT, arxiv 2302.06590) | **Low (foil)** | Cite once as the "headline 55% productivity number" that says nothing about quality |
| 4 | Pragmatic Engineer, AI tooling 2026 | **Low** | Redundant with DORA on adoption |
| 5 | Deloitte 2026 software industry outlook | **Medium** | Adds the agentic AI cyber attack angle and the 80% team restructuring claim |
| 6 | Octoverse 2025 | **Medium to High** | Adoption baseline plus Dependabot fix time data |
| 7 | Octoverse 2024 | **High (contrarian)** | GitHub's own data says quality has *not* dropped. Cite it explicitly |
| 8 | Kabir et al. 2023, "Is Stack Overflow Obsolete?" (arxiv 2308.02312) | **High (academic)** | Peer reviewed evidence on AI code correctness *and* human overconfidence |
| 9 | Eventually Making, AI impact on SWE in 2026 | **Skip** | Practitioner blog, no primary data |
| 10 | Baytech Consulting, Unlocking 2026 | **Skip** | Vendor pitch, redundant with Faros AI |
| 11 | PCMag, Samsung ChatGPT ban | **Medium (use as the secondary)** | Samsung 2023 incident, corroborating outlet |
| 12 | Bloomberg, Samsung ChatGPT ban | **Medium to High (use as the primary)** | Same incident, the canonical source |

---

## Detailed evaluation

### 1. Gartner, "AI Agents Transforming Software Engineering"

**URL:** https://www.gartner.com/en/articles/ai-agents-transforming-software-engineering

**What it is.** A Gartner article (analyst opinion piece) on how AI agents change SWE workflows. We could not fetch the full text directly because Gartner blocks scrapers, but the URL fragment ("AI agents should increase efficiency...maintaining customer trust and satisfaction") tells us roughly what frame it takes.

**Relevance.** **Low.** Gartner pieces of this kind tend to be vendor neutral but very generic. They are useful for situating "what the industry consensus thinks AI agents will do" but they do not give us measurable claims about code quality or security. We already have DORA for the consensus framing.

**If we use it.** Cite once in passing as evidence that the topic is on the radar of major industry analysts. Do not lean on it for any specific claim.

---

### 2. Gartner, "Top Strategic Trends in Software Engineering for 2025 and Beyond"

**URL:** https://www.gartner.com/en/newsroom/press-releases/2025-07-01-gartner-identifies-the-top-strategic-trends-in-software-engineering-for-2025-and-beyond

**What it is.** Gartner press release from July 2025 introducing the term **"AI-Native Software Engineering"** and projecting that **90% of enterprise software engineers will use AI code assistants by 2028** (up from less than 14% in early 2024). Also includes the prediction that by 2030, 80% of organisations will evolve large engineering teams into smaller AI augmented teams.

**Relevance.** **Medium.** The 90% by 2028 figure overlaps with DORA's "90% already" claim, which actually makes both stronger when cited together (DORA says we are already there, Gartner predicted we would be there in three more years). The "AI-Native SWE" term is useful jargon for the short report.

**If we use it.** Use as the *industry analyst* counterpart to DORA's *survey* data. Pair them in one sentence: Gartner predicted rapid adoption, DORA confirmed it has already happened.

---

### 3. Peng et al. (2023), "The Impact of AI on Developer Productivity: Evidence from GitHub Copilot" (arxiv 2302.06590)

**URL:** https://arxiv.org/pdf/2302.06590

**What it is.** Controlled experiment by GitHub researchers (Sida Peng, Eirini Kalliamvakou, Peter Cihon, Mert Demirer) where developers were assigned to use Copilot or not on an HTTP server task. Headline finding: Copilot users finished **55.8% faster** than the control group.

**Relevance.** **Low (but worth mentioning as a foil).** This is the most cited paper on AI assisted coding in the entire field. It does *not* measure code quality or security at all, only speed. The whole project's argument is that productivity gains hide quality and security costs, so cite this paper *exactly once*, as the "headline number that everyone remembers but that does not tell you anything about whether the code is good." This actually strengthens our framing.

**Caveat.** The paper is funded by GitHub, the company that sells Copilot. Our source criticism sentence in the draft already covers this kind of vendor publication, but we should mention it directly when citing.

**If we use it.** One sentence in the motivation: "The most cited number on AI assisted coding is the 55% speedup measured in Peng et al. 2023, but that paper measures task completion time only, not whether the resulting code is maintainable or secure."

---

### 4. Pragmatic Engineer, "AI Tooling for Software Engineers in 2026"

**URL:** https://newsletter.pragmaticengineer.com/p/ai-tooling-2026

**What it is.** Gergely Orosz and Elin Nilsson, March 2026, based on a survey of 900+ engineers. Headlines: 95% use AI tools at least weekly, Claude Code went from zero to #1 in eight months, 70% use 2 to 4 tools simultaneously, 55% use AI agents for review and bug fixing.

**Relevance.** **Low.** Adoption data only, no quality or security findings. The 95% weekly figure is essentially the same story as DORA's "90% daily" but from a different sample. Citing both is redundant.

**If we use it.** Skip for the draft. Could be useful in the short report's *introduction* if we want a second adoption number from a different sample, but not load bearing.

---

### 5. Deloitte, "2026 Global Software Industry Outlook"

**URL:** https://www.deloitte.com/us/en/insights/industry/technology/technology-media-telecom-outlooks/software-industry-outlook.html

**What it is.** Big firm analyst outlook for 2026. Two interesting claims for us:
- "AI could potentially drive productivity gains of 30% to 35% across the SDLC"
- A novel security angle: in late 2025, attackers used jailbroken AI tools to conduct attacks where "about 80% to 90% of the agentic attack was conducted without any human involvement."

**Relevance.** **Medium.** The agentic AI cyber attack data is *new ground* that we do not currently cover. Our security thread is mostly about *defensive* failure (vulnerable AI generated code reaching production). Deloitte adds the *offensive* dimension: AI accelerating the attackers as well as the defenders. That is a one paragraph addition that would make the security section more complete.

**If we use it.** Add one sentence to the challenges or motivation section: AI is also accelerating the attacker side of the equation, not just the defender side, with autonomous attack chains now requiring minimal human involvement.

---

### 6. Octoverse 2025 (GitHub blog)

**URL:** https://github.blog/news-insights/octoverse/octoverse-a-new-developer-joins-github-every-second-as-ai-leads-typescript-to-1/

**What it is.** GitHub's annual report on its own platform, 2025 edition. Notable findings:
- 180+ million developers, 36 million joined in 2025 alone
- **Nearly 80% of new developers use GitHub Copilot in their first week**
- 1.1+ million public repositories use an LLM SDK
- TypeScript became the most used language in August 2025
- Dependabot fix times dropped from 200 to 300 days down to 30 to 50 days

**Relevance.** **Medium to High.** The 80% Copilot adoption among new developers is the strongest "AI is the default" data point we have, even better than DORA's 90% (because it shows AI is now the *first* thing junior developers learn, not something they migrate to). The Dependabot improvement is genuine evidence that *some* aspects of code security are getting better with automation, which again is a useful contrarian counterweight to our mostly negative security framing.

**If we use it.** Cite for two things: (1) "AI is now the default for new developers" in the motivation section, and (2) "automated vulnerability fixing is one area where the picture is improving" as an honest qualifier in the security challenges section.

---

### 7. Octoverse 2024 (GitHub blog)

**URL:** https://github.blog/news-insights/octoverse/octoverse-2024/

**What it is.** GitHub's 2024 annual report. Most relevant finding for us: **"No rise in rejected pull requests despite 1.4 million new open source contributors, suggesting quality remains intact."**

**Relevance.** **High, and specifically because it contradicts our thesis.** This is the most valuable source in the whole batch. GitHub's own data says PR rejection rates have *not* increased even as the contributor base has exploded. That is direct counter evidence to the AI slop / curl narrative we are building. Citing a source that contradicts our argument is the single best thing we can do to make the project look academically honest.

**If we use it.** Add one paragraph either in the challenges section or in the "still loose" section: "Not all the data points the same way. GitHub's own Octoverse 2024 reports that PR rejection rates have not risen even as 1.4 million new contributors joined open source projects in 2024, which complicates the simple 'AI slop is overwhelming maintainers' picture. We need to reconcile this with the curl and Ghostty incidents, possibly by distinguishing between rejection rate (which can stay flat if maintainers just stop reviewing) and reviewer effort per PR (which the Faros AI data says has increased)."

That paragraph alone would lift the draft's grade.

---

### 8. Kabir et al. (2023), "Is Stack Overflow Obsolete? An Empirical Study of the Characteristics of ChatGPT Answers to Stack Overflow Questions" (arxiv 2308.02312)

**URL:** https://arxiv.org/pdf/2308.02312

**What it is.** Peer reviewed academic paper, conditionally accepted at CHI 2024. Authors evaluated ChatGPT's responses to 517 programming questions from Stack Overflow. Findings:
- **52% of ChatGPT answers contain incorrect information**
- **77% are verbose**
- Despite this, users still preferred ChatGPT answers 35% of the time
- Users overlooked the misinformation in ChatGPT answers **39% of the time**

**Relevance.** **High.** This is the academic source we have been missing. Two reasons it is gold:
1. It is peer reviewed at a top tier venue (CHI), unlike most of our current sources which are vendor reports or industry blog posts.
2. The "users prefer the wrong answer" finding is the *human* side of our argument: it is not just that AI generates buggy code, it is that humans are systematically overconfident in AI output. That is the mechanism behind why the Veracode 45% baseline reaches production.

**If we use it.** Make this one of the load bearing citations in the motivation section. It pairs naturally with the DORA "AI amplifies" framing: humans accept AI output too easily, so weak teams degrade faster.

---

### 9. Eventually Making, "AI's Impact on the State of the Art in Software Engineering in 2026"

**URL:** https://eventuallymaking.io/p/ai-s-impact-on-the-state-of-the-art-in-software-engineering-in-2026

**What it is.** Personal blog post by Hugo, a senior engineer, published February 2026. Discusses Context Driven Engineering, Spec/Plan/Act workflow, agents.md files, and how teams at Doctolib, Malt, Google, and Alan are organising AI assisted work.

**Relevance.** **Skip.** Practitioner blog, no primary data, no novel findings. The topics it covers (how to organise AI assisted teams, junior training gaps) are interesting but they are *adjacent* to our research questions, not on them.

**If we use it.** Do not.

---

### 10. Baytech Consulting, "Unlocking 2026: The Future of AI-Driven Software Development"

**URL:** https://www.baytechconsulting.com/blog/unlocking-ai-software-development-2026

**What it is.** Blog post by Bryan Reynolds, CEO of Baytech Consulting. Coins or repeats the term "Almost Right" for code that looks correct but contains subtle flaws. Cites the 91% review time figure.

**Relevance.** **Skip.** Vendor pitch with selective data support. The 91% figure traces back to Faros AI, which we already cite (and which is itself a vendor). Citing this would be triple counting the same number through two layers of vendor PR.

**If we use it.** Do not. If we want the "Almost Right" framing, we can use the phrase ourselves without citing a consulting blog as the source.

---

### 11. PCMag, "Samsung Bans ChatGPT After Engineers Use It to Fix Proprietary Code"

**URL:** https://www.pcmag.com/news/samsung-bans-chatgpt-after-engineers-use-it-to-fix-proprietary-code

**What it is.** News coverage of the April 2023 Samsung incident. Samsung engineers pasted proprietary semiconductor source code into ChatGPT three separate times within three weeks, looking for help fixing bugs and optimising test sequences. One engineer also pasted a transcript of an internal meeting. Samsung's response was to ban generative AI use on company devices in May 2023.

**Relevance.** **Medium, use as the secondary source for the Samsung incident.** Important caveat: this happened in **April 2023**, which is *before* the project's 2025 to 2026 focus window. But it is the canonical "first wave" example of the AI security risk, and it predates the more recent stuff in a way that strengthens the argument: the security concerns we are documenting in 2025 to 2026 are not new, they are an old known problem that the industry has not solved.

**If we use it.** Cite alongside Bloomberg as a confirming outlet. Probably not as a third primary use case (we already have Clawdbot and curl), but as a one sentence reference in the motivation section to make the point that AI security incidents have been happening since the technology became mainstream.

---

### 12. Bloomberg, "Samsung Bans ChatGPT and Other Generative AI Use by Staff After Leak"

**URL:** https://www.bloomberg.com/news/articles/2023-05-02/samsung-bans-chatgpt-and-other-generative-ai-use-by-staff-after-leak

**What it is.** Bloomberg's reporting on the same incident, published May 2, 2023. Bloomberg is the canonical source: they reviewed the internal Samsung memo and have the most authoritative account.

**Relevance.** **Medium to High.** Same as PCMag in content, but stronger as a citation because Bloomberg is a tier one news outlet. If we use the Samsung incident at all, this is the URL to cite.

**If we use it.** As above. One sentence reference in the motivation to establish the historical baseline. Cite Bloomberg as the primary, PCMag as a corroborating outlet if we want two sources for the same fact.

---

## What this changes for the draft

If we adopt the high relevance items (Octoverse 2024, Kabir et al. 2023, Octoverse 2025, plus the Samsung incident from Bloomberg and Deloitte's autonomous attack angle), the draft gains:

1. **A peer reviewed academic citation** (Kabir et al.) which the current draft is missing.
2. **A contrarian data point** (Octoverse 2024 PR rejection rates) which makes the project look academically honest.
3. **A historical anchor** (Samsung 2023) which shows the security thread is not a 2025 invention.
4. **An offensive security angle** (Deloitte agentic AI attacks) which fills a gap in our security thread.
5. **A "default for new developers" framing** (Octoverse 2025 80% Copilot adoption in first week) which is sharper than the DORA 90%.

Estimated effort to integrate all five into the current draft: about an hour. We can do it now or save it for the short report in May.

## What we should drop or never add

- Eventually Making (practitioner blog, no data)
- Baytech Consulting (vendor pitch, double cited number)
- Pragmatic Engineer (redundant adoption data)
- Gartner AI agents article (too generic to lean on)

## Borderline calls (use with care)

- Peng et al. 2023, only as a foil for the "headline productivity number tells you nothing about quality" point.
- Gartner top trends 2025, only as a paired citation with DORA, not on its own.

---

*This evaluation is intentionally opinionated. The goal is to save the team reading time. If you disagree with a verdict, push back and we can re evaluate that specific source.*
