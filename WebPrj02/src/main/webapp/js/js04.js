window.onload = function(){
		let 	menus 	 = ['사과','배','바나나','딸기', '수박', '망고', '참외', '자몽', '포도', '오렌쥐', '됨'];
		let		html	 = '<ul>'
		
/*		html		    += '<li><a>사과</a></li>'
		html 			+= '<li><a>배</a></li>'		
		html 			+= '<li><a>바나나</a></li>'
		html 			+= '<li><a>딸기</a></li>'
		html 			+= '<li><a>수박</a></li>'
		html 			+= '<li><a>망고</a></li>' 		
		
		for ( let i = 0; i < menus.length; i++ ) {			
			html	+=	 '<li><a>'+menus[i]+'</a></li>';			
		}    																		*/
		
		
		for ( let element of menus) {
			html += `<li><a> ${element} </a></li>`;
			
		}
				
		html 			+= '</ul>'
		
	
		
		const	outputEl = document.getElementById('output');
		outputEl.innerHTML = html;
	}